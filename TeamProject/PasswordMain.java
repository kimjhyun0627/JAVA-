package TeamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordMain extends JFrame implements ActionListener
{
    public static final JPanel currentPanel = new JPanel();
    public static final Color BACKGROUND_COLOR = new Color(0xededf9);
    private JButton mailSubmitBtn;
    private JButton codeVerifyBtn;
    private JButton gotoMainBtn;
    private JButton changePWBtn;
    private JButton changePWSubmitBtn;
    private MailPage mailPage;
    private CodeVerifyPage codePage;
    private JPanel passwordPage;
    private ChangePage changePage;
    private String verifiedCode;

    public static void main(String[] args)
    {
        PasswordMain t = new PasswordMain();
        t.setVisible(true);
    }

    public PasswordMain()
    {
        super("test");
        setSize(660, 990);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600, 10);
        setResizable(false);
        setLayout(new BorderLayout());

        currentPanel.setBackground(BACKGROUND_COLOR);

        Container test = this.getContentPane();
        test.setBackground(BACKGROUND_COLOR);
        JPanel viewPanel = new JPanel();
        viewPanel.setBackground(BACKGROUND_COLOR);
        viewPanel.add(currentPanel);
        test.add(viewPanel, BorderLayout.CENTER);

        mailSubmitPage("");

        setVisible(true);
    }

    private void mailSubmitPage(String errorMSG)
    {
        mailPage = new MailPage(errorMSG);

        mailSubmitBtn = new ButtonForm("./image/mailSubmitButton");
        mailSubmitBtn.addActionListener(this);

        mailPage.add(mailSubmitBtn);

        currentPanel.add(mailPage, BorderLayout.CENTER);
    }

    private void codeVerifyPage(String errorMSG)
    {
        codePage = new CodeVerifyPage(errorMSG);

        codeVerifyBtn = new ButtonForm("./image/codeVerifyButton");
        codeVerifyBtn.addActionListener(this);

        codePage.add(codeVerifyBtn);

        currentPanel.add(codePage, BorderLayout.CENTER);
    }

    private void showPasswordPage(boolean b)
    {
        gotoMainBtn = new ButtonForm("./image/gotoMainButton");
        gotoMainBtn.addActionListener(this);

        if (b)
        {
            passwordPage = new findPassword(true);

            changePWBtn = new ButtonForm("./image/changePWButton");
            changePWBtn.addActionListener(this);
            JPanel wrapperPanel = new JPanel(new FlowLayout());
            wrapperPanel.add(changePWBtn);
            wrapperPanel.add(gotoMainBtn);
            wrapperPanel.setBackground(BACKGROUND_COLOR);

            passwordPage.add(wrapperPanel);
        }
        else
        {
            passwordPage = new findPasswordError();
            passwordPage.add(gotoMainBtn);
        }
        currentPanel.add(passwordPage);
    }

    private void showChangePage(String errorMSG)
    {
        changePage = new ChangePage(errorMSG);

        changePWSubmitBtn = new ButtonForm("./image/changePWButton");
        changePWSubmitBtn.addActionListener(this);

        changePage.add(changePWSubmitBtn);

        currentPanel.add(changePage);
    }

    private void showLastPage()
    {
        passwordPage = new findPassword(false);
        gotoMainBtn = new ButtonForm("./image/gotoMainButton");
        gotoMainBtn.addActionListener(this);
        passwordPage.add(gotoMainBtn);

        currentPanel.add(passwordPage);
    }

    private void end()
    {
        JLabel end = new centerBoldLabel("END!!!", 65);

        currentPanel.add(end);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        currentPanel.removeAll();

        if (e.getSource() == mailSubmitBtn)
        {
            String str = mailPage.getMailAddress();

            if (str.equals("kimjhyun0627"))
            {
                mailSender mail = new mailSender(str);
                verifiedCode = mail.getCode();
                codeVerifyPage("");
            }
            else if (str.length() == 0)
            {
                mailSubmitPage("웹메일을 입력해주세요");
            }
            else
            {
                mailSubmitPage("등록되지 않은 웹메일입니다");
            }
        }

        if (e.getSource() == codeVerifyBtn)
        {
            String str = codePage.getCodeInput();

            if (str.equals(verifiedCode))
            {
                showPasswordPage(true);
            }
            else if (str.length() == 0)
            {
                codeVerifyPage("인증코드를 입력해주세요");
            }
            else if (str.equals("4321"))
            {
                showPasswordPage(false);
            }
            else
            {
                codeVerifyPage("잘못된 인증코드입니다");
            }
        }

        if(e.getSource() == changePWBtn)
        {
            showChangePage("");
        }
        
        if (e.getSource() == changePWSubmitBtn)
        {
            String str = changePage.getChangedPassword();

            if (str.length() == 0)
            {
                showChangePage("비밀번호를 입력해주세요");
            }
            else if (Cabinet.isValidPW(str))
            {
                showLastPage();//다음장으로
            }
            else
            {
                showChangePage("잘못된 비밀번호입니다");
            }
        }

        if(e.getSource() == gotoMainBtn)
        {
            end();
        }

        currentPanel.updateUI();
    }
}
