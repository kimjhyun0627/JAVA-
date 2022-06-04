package TeamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddMediMain extends JFrame implements ActionListener
{
    public static final JPanel currentPanel = new JPanel();
    public static final Color BGCOLOR = new Color(0xededf9);

    private JButton medi1Btn;
    private JButton medi2Btn;
    private JButton medi3Btn;
    private JButton yesBtn;
    private JButton noBtn;
    private JButton gotostartBtn;

    private AddMedi_statusPage statusPage;
    private AddMedi_editstatusPage editPage;
    private AddMedi_completePage completePage;

    //DB에서 받아오는 아이로 바꾸기
    private String medi_name;
    private int medi_num;

    public static void main(String[] args)
    {
        AddMediMain main = new AddMediMain();
        main.setVisible(true);
        return;
    }

    public AddMediMain()
    {
        super("AddMedi Main");
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

        statusPage();

        setVisible(true);
    }

    private void statusPage()
    {
        statusPage = new AddMedi_statusPage();

        //DB생기면 list로 처리?
        medi1Btn = new ButtonForm("./image/codeVerifyButton");
        medi1Btn.addActionListener(this);

        medi2Btn = new ButtonForm("./image/codeVerifyButton");
        medi2Btn.addActionListener(this);

        medi3Btn = new ButtonForm("./image/codeVerifyButton");
        medi3Btn.addActionListener(this);

        JPanel itemPanel1 = new JPanel(new GridLayout(1, 2));
        itemPanel1.setBackground(new Color(0xededf9));
        medi_name = "감기약";
        medi_num = 5;
        mediNameLabel medi_name1 = new mediNameLabel(medi_name + " " + medi_num + "개"); //이름 + 개수

        JPanel itemPanel2 = new JPanel(new GridLayout(1, 2));
        itemPanel2.setBackground(new Color(0xededf9));
        mediNameLabel medi_name2 = new mediNameLabel("반창고" + " " + "7" + "개");

        JPanel itemPanel3 = new JPanel(new GridLayout(1, 2));
        itemPanel3.setBackground(new Color(0xededf9));
        mediNameLabel medi_name3 = new mediNameLabel("파 스" + " " + "10" + "개");

        itemPanel1.add(medi_name1);
        itemPanel1.add(medi1Btn);

        itemPanel2.add(medi_name2);
        itemPanel2.add(medi2Btn);

        itemPanel3.add(medi_name3);
        itemPanel3.add(medi3Btn);

        statusPage.add(itemPanel1);
        statusPage.add(itemPanel2);
        statusPage.add(itemPanel3);

        currentPanel.add(statusPage, BorderLayout.CENTER);
    }

    private void editPage()
    {
        editPage = new AddMedi_editstatusPage();

        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.setBackground(new Color(0xededf9));

        //DB에서 데이터 가져온거
        medi_name = "감기약 ";

        //medi 개수 변수에 저장하기
        JTextField inputText = new JTextField(2);
        inputText.setFont(new Font("IM혜민 bold", Font.BOLD, 42));

        mediNameLabel inputLabel = new mediNameLabel(medi_name);
        mediNameLabel addLabel = new mediNameLabel(" 개 를");

        titlePanel.add(inputLabel);
        titlePanel.add(inputText);
        titlePanel.add(addLabel);

        JPanel subtitlePanel = new JPanel(new GridLayout(1, 1));
        subtitlePanel.setBackground(new Color(0xededf9));

        mediNameLabel subLabel = new mediNameLabel("추가하시겠습니까?");
        subtitlePanel.add(subLabel);

        JPanel checkPanel = new JPanel(new GridLayout(1, 2));

        yesBtn = new ButtonForm("./image/yes");
        yesBtn.addActionListener(this);

        noBtn = new ButtonForm("./image/no");
        noBtn.addActionListener(this);

        checkPanel.add(yesBtn);
        checkPanel.add(noBtn);

        editPage.add(titlePanel);
        editPage.add(subtitlePanel);
        editPage.add(checkPanel);

        currentPanel.add(editPage, BorderLayout.CENTER);
    }

    private void completePage()
    {
        medi_name = "예시예시";
        medi_num = 8;
        completePage = new AddMedi_completePage(medi_name, medi_num);

        gotostartBtn = new ButtonForm("./image/gotoMainButton");
        gotostartBtn.addActionListener(this);

        completePage.add(gotostartBtn);

        currentPanel.add(completePage, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        currentPanel.removeAll();

        if (e.getSource() == medi1Btn)
        {
            editPage();
        }
        if (e.getSource() == yesBtn)
        {
            //DB medi 개수 바꾸기
            completePage();
        }
        if (e.getSource() == noBtn)
        {
            statusPage();
        }
        if (e.getSource() == gotostartBtn)
        {
            //main 페이지로
        }

        currentPanel.updateUI();
    }
}
