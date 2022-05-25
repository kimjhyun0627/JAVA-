package TeamProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PasswordMain extends JFrame implements ActionListener
{
    public static final JPanel currentPanel = new JPanel();
    public static final Color BGCOLOR = new Color(0xF2F2FD);
    private JButton mailSubmitBtn;
    private JButton codeVerifyBtn;
    private JButton gotoMainBtn;
    private JButton changePWBtn;
    private MailPage mailPage;
    private CodeVerifyPage codePage;
    private JPanel passwordPage;

    public static void main(String[] args)
    {
        PasswordMain t = new PasswordMain();
        t.setVisible(true);
        return;
    }

    public PasswordMain()
    {
        super("test");
        setSize(660, 990);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600, 10);
        setResizable(false);
        setLayout(new BorderLayout());

        currentPanel.setBackground(BGCOLOR);

        Container test = this.getContentPane();
        test.setBackground(BGCOLOR);
        JPanel viewPanel = new JPanel();
        viewPanel.setBackground(BGCOLOR);
        viewPanel.add(currentPanel);
        test.add(viewPanel, BorderLayout.CENTER);

        mailSubmitPage(0);
        //showPasswordPage(false);

        setVisible(true);
    }

    void mailSubmitPage(int errorCode)
    {
        String errorStr = "";

        if (errorCode == 1)
        {
            errorStr += "등록되지 않은 웹메일입니다";
        }
        else if (errorCode == 0)
        {
            errorStr +="";
        }
        else if (errorCode == -1)
        {
            errorStr += "웹메일을 입력해주세요";
        }
        else
        {
            errorStr += "알 수 없는 오류입니다";
        }

        mailPage = new MailPage(errorStr);

        mailSubmitBtn = new ButtonForm("./image/mailSubmitButton.png");
        mailSubmitBtn.addActionListener(this);

        mailPage.add(mailSubmitBtn);

        currentPanel.add(mailPage, BorderLayout.CENTER);
    }

    void codeVerifyPage(int errorCode)
    {
        String errorStr = "";
        if (errorCode == 1)
        {
            errorStr += "인증코드가 잘못되었습니다";
        }
        else if (errorCode == 0)
        {
            errorStr += "";
        }
        else if (errorCode == -1)
        {
            errorStr += "인증코드를 입력해주세요";
        }
        else
        {
            errorStr += "알 수 없는 오류입니다";
        }

        codePage = new CodeVerifyPage(errorStr);

        codeVerifyBtn = new ButtonForm("./image/codeVerifyButton.png");
        codeVerifyBtn.addActionListener(this);

        codePage.add(codeVerifyBtn);

        currentPanel.add(codePage, BorderLayout.CENTER);
    }

    void showPasswordPage(boolean b)
    {
        gotoMainBtn = new ButtonForm("./image/gotoMainButton.png");
        gotoMainBtn.addActionListener(this);

        if(b)
        {
            passwordPage = new findPassword();

            changePWBtn = new ButtonForm("./image/changePWButton.png");
            changePWBtn.addActionListener(this);
            JPanel wrapperPanel = new JPanel(new FlowLayout());
            wrapperPanel.add(changePWBtn);
            wrapperPanel.add(gotoMainBtn);
            wrapperPanel.setBackground(BGCOLOR);

            passwordPage.add(wrapperPanel);
        }
        else
        {
            passwordPage = new findPasswordError();
            passwordPage.add(gotoMainBtn);
        }
        currentPanel.add(passwordPage);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        currentPanel.removeAll();

        if (e.getSource() == mailSubmitBtn)
        {
            String str = mailPage.getMailAddress();

            if (str.equals("aaaa"))
            {
                codeVerifyPage(0);
            }
            else if (str.length() == 0)
            {
                mailSubmitPage(-1);
            }
            else
            {
                mailSubmitPage(1);
            }
        }

        if (e.getSource() == codeVerifyBtn)
        {
            String str = codePage.getCodeInput();

            if (str.equals("1234"))
            {
                showPasswordPage(true);
            }
            else if (str.length() == 0)
            {
                codeVerifyPage(-1);
            }
            else if(str.equals("4321"))
            {
                showPasswordPage(false);
            }
            else
            {
                codeVerifyPage(1);
            }
        }

        currentPanel.updateUI();
    }
}
