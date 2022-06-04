package TeamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckborrowMain extends JFrame implements ActionListener
{
    public static final JPanel currentPanel = new JPanel();
    public static final Color BGCOLOR = new Color(0xededf9);

    private Checkborrow_selectPage selectPage;
    private Checkborrow_matlogPage matlogPage;
    private Checkborrow_ummlogPage ummlogPage;
    private Checkborrow_medilogPage medilogPage;
    private Checkborrow_gotomainPage gotomainPage;

    private JButton matBtn;
    private JButton ummBtn;
    private JButton mediBtn;
    private JButton allBtn;
    private JButton okayBtn;
    private JButton gotostartBtn;

    public static void main(String[] args)
    {
        CheckborrowMain main = new CheckborrowMain();
        main.setVisible(true);
    }

    public CheckborrowMain()
    {
        super("Checkborrow Main");
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

        selectPage();

        setVisible(true);
    }

    private void selectPage()
    {
        selectPage = new Checkborrow_selectPage();

        matBtn = new ButtonForm2("./image/Mat");
        matBtn.addActionListener(this);

        ummBtn = new ButtonForm2("./image/Umm");
        ummBtn.addActionListener(this);

        mediBtn = new ButtonForm2("./image/Med");
        mediBtn.addActionListener(this);

        allBtn = new ButtonForm2("./image/All");
        allBtn.addActionListener(this);

        selectPage.add(matBtn);
        selectPage.add(ummBtn);
        selectPage.add(mediBtn);
        selectPage.add(allBtn);

        currentPanel.add(selectPage, BorderLayout.CENTER);
    }

    private void matlogPage()
    {
        matlogPage = new Checkborrow_matlogPage();

        //list로 구현하고 layout 크기 수정하기
        JPanel logPanel = new JPanel(new GridLayout(2, 1));
        logPanel.setBackground(new Color(0xededf9));

        //돗자리 log 기록 가져오기
        JLabel index = new JLabel("ID  상태         학생ID          대여시간     반납시간");
        JLabel exlog = new JLabel(" 1  대여    2020111111  22/05/10/12:00    -");
        index.setFont(new Font("IM혜민 bold", Font.BOLD, 20));
        exlog.setFont(new Font("IM혜민 bold", Font.BOLD, 20));

        logPanel.add(index);
        logPanel.add(exlog);

        matlogPage.add(logPanel);

        okayBtn = new ButtonForm("./image/codeVerifyButton");
        okayBtn.addActionListener(this);

        matlogPage.add(okayBtn);

        currentPanel.add(matlogPage, BorderLayout.CENTER);
    }

    private void ummlogPage()
    {
        ummlogPage = new Checkborrow_ummlogPage();

        //list로 구현하고 layout 크기 수정하기
        JPanel logPanel = new JPanel(new GridLayout(2, 1));
        logPanel.setBackground(new Color(0xededf9));

        //우산 log 기록 가져오기
        JLabel index = new JLabel("물품ID  대여여부    학생ID          빌린시간     반납여부");
        JLabel exlog = new JLabel("  1      O    2020111111  22/05/10/12:00    X");
        index.setFont(new Font("IM혜민 bold", Font.BOLD, 20));
        exlog.setFont(new Font("IM혜민 bold", Font.BOLD, 20));

        logPanel.add(index);
        logPanel.add(exlog);

        ummlogPage.add(logPanel);

        okayBtn = new ButtonForm("./image/codeVerifyButton");
        okayBtn.addActionListener(this);

        ummlogPage.add(okayBtn);

        currentPanel.add(ummlogPage, BorderLayout.CENTER);
    }

    private void medilogPage()
    {
        medilogPage = new Checkborrow_medilogPage();

        //list로 구현하고 layout 크기 수정하기
        JPanel logPanel = new JPanel(new GridLayout(2, 1));
        logPanel.setBackground(new Color(0xededf9));

        //돗자리 log 기록 가져오기
        JLabel index = new JLabel("물품ID  대여여부    학생ID          빌린시간     반납여부");
        JLabel exlog = new JLabel("  1      O    2020111111  22/05/10/12:00    X");
        index.setFont(new Font("IM혜민 bold", Font.BOLD, 20));
        exlog.setFont(new Font("IM혜민 bold", Font.BOLD, 20));

        logPanel.add(index);
        logPanel.add(exlog);

        medilogPage.add(logPanel);

        okayBtn = new ButtonForm("./image/codeVerifyButton");
        okayBtn.addActionListener(this);

        medilogPage.add(okayBtn);

        currentPanel.add(medilogPage, BorderLayout.CENTER);
    }

    private void gotomainPage()
    {
        gotomainPage = new Checkborrow_gotomainPage();

        gotostartBtn = new ButtonForm("./image/gotoMainButton");
        gotostartBtn.addActionListener(this);

        gotomainPage.add(gotostartBtn);

        currentPanel.add(gotomainPage, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        currentPanel.removeAll();

        if (e.getSource() == matBtn)
        {
            matlogPage();
        }
        if (e.getSource() == ummBtn)
        {
            ummlogPage();
        }
        if (e.getSource() == mediBtn)
        {
            medilogPage();
        }
        if (e.getSource() == allBtn)
        {
            gotomainPage();
        }

        if (e.getSource() == okayBtn)
        {
            gotomainPage();
        }

        if (e.getSource() == gotostartBtn)
        {
            //메인페이지로
        }

        currentPanel.updateUI();

    }
}
