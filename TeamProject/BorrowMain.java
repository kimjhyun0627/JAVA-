package TeamProject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BorrowMain extends JFrame implements ActionListener
{
    public static final JPanel currentPanel = new JPanel();
    public static final Color BGCOLOR = new Color(0xededf9);
    private JButton userinfosubmitBtn;
    private JButton matBtn;
    private JButton mat1Btn;
    private JButton mat2Btn;
    private JButton mat3Btn;
    private JButton mat4Btn;
    private JButton ummBtn;
    private JButton umm1Btn;
    private JButton umm2Btn;
    private JButton umm3Btn;
    private JButton umm4Btn;
    private JButton medBtn;
    private JButton med1Btn;
    private JButton med2Btn;
    private JButton med3Btn;
    private JButton OKComfirmBtn;
    private JButton MedOKComfirmBtn;

    private JButton OKReturnBtn;
    private JButton MatAgreeBtn;
    private JButton MatAgreeRBtn;
    private JButton UmmAgreeBtn;
    private JButton UmmAgreeRBtn;
    private JButton MedAgreeBtn;
    private JButton MatOKTermsBtn;
    private JButton MedOKTermsBtn;
    private JButton UmmOKTermsBtn;
    private JButton OKReturnGuideBtn;
    private JButton gotoMainBtn;
    BorrowObject[] ObjList;

    //임시
    private MatObj[] MatList = new MatObj[4];
    private MatObj mat1;
    private MatObj mat2;
    private MatObj mat3;
    private MatObj mat4;

    private UmmObj umm1 = new UmmObj(1, new Date(2022, 6, 3, 12, 30, 10), new Date(2022, 6, 4, 11, 15, 5), "2021111111");
    private UmmObj umm2 = new UmmObj(2, new Date(2022, 6, 4, 12, 30, 10), new Date(2022, 6, 4, 11, 15, 5), "2021111111");
    private UmmObj umm3 = new UmmObj(3, new Date(2022, 6, 2, 12, 30, 10), new Date(2022, 6, 3, 11, 15, 5), "2021111111");
    private UmmObj umm4 = new UmmObj(4, new Date(2022, 5, 31, 12, 30, 10), new Date(2022, 6, 1, 11, 15, 5), "2021111111");

    private B_infoPage infoPage;
    private B_ObjSelect objSelectPage;
    private B_MatSelect matSelectPage;
    private B_UmmSelect ummSelectPage;
    private B_MedSelect medSelectPage;
    // private JPanel matSelectPage;
    private JPanel matSelectinfo;
    private B_BorrowComfirm borrowComfirmPage;
    private B_UseComfirm useComfirmPage;
    private B_ReturnPage returnPage;
    private Terms termsPage;
    private B_ReturnGuidePage returnguidePage;
    private CompletePage completePage;
    private boolean MatAgree = false;
    private boolean MatAgreeR = false;
    private boolean UmmAgree = false;
    private boolean UmmAgreeR = false;
    private boolean MedAgree = false;


    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        BorrowMain b = new BorrowMain();
        b.setVisible(true);
        return;

    }

    /*
     * public void dataGetter() { Scanner FileReader_Mat = null; MatList = new
     * ArrayList<B_MatObj>();
     *
     * try { FileReader_Mat = new Scanner(new
     * FileInputStream("./data/mat.txt")); while (FileReader_Mat.hasNext()) {
     * int f_ID = FileReader_Mat.nextInt(); Date f_dateStart = null ; int
     * f_year_Start = FileReader_Mat.nextInt(); int f_month_Start =
     * FileReader_Mat.nextInt(); int f_day_Start = FileReader_Mat.nextInt(); int
     * f_hour_Start = FileReader_Mat.nextInt(); int f_minute_Start =
     * FileReader_Mat.nextInt(); int f_second_Start = FileReader_Mat.nextInt();
     * f_dateStart.setDate(f_year_Start, f_month_Start, f_day_Start,
     * f_hour_Start, f_minute_Start, f_second_Start); Date f_dateHaveto = null ;
     * int f_year_Haveto = FileReader_Mat.nextInt(); int f_month_Haveto =
     * FileReader_Mat.nextInt(); int f_day_Haveto = FileReader_Mat.nextInt();
     * int f_hour_Haveto = FileReader_Mat.nextInt(); int f_minute_Haveto =
     * FileReader_Mat.nextInt(); int f_second_Haveto = FileReader_Mat.nextInt();
     * f_dateHaveto.setDate(f_year_Haveto, f_month_Haveto, f_day_Haveto,
     * f_hour_Haveto, f_minute_Haveto, f_second_Haveto); Date f_dateEnd = null ;
     * int f_year_End = FileReader_Mat.nextInt(); int f_month_End =
     * FileReader_Mat.nextInt(); int f_day_End = FileReader_Mat.nextInt(); int
     * f_hour_End = FileReader_Mat.nextInt(); int f_minute_End =
     * FileReader_Mat.nextInt(); int f_second_End = FileReader_Mat.nextInt();
     * f_dateEnd.setDate(f_year_End, f_month_End, f_day_End, f_hour_End,
     * f_minute_End, f_second_End); String f_studentID = FileReader_Mat.next();
     * String f_isBorrowing = FileReader_Mat.next();
     *
     * MatList.add(new B_MatObj(f_ID, f_dateStart, f_dateHaveto, f_dateEnd,
     * f_studentID));
     *
     * } FileReader_Mat.close(); } catch (FileNotFoundException e) {
     * e.printStackTrace(); } }
     */

    public BorrowMain()
    {
        super("test");
        setSize(660, 990);
        setLocation(600, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        currentPanel.setBackground(BGCOLOR);

        Container test = this.getContentPane();
        test.setBackground(BGCOLOR);
        JPanel viewPanel = new JPanel();
        viewPanel.setBackground(BGCOLOR);
        viewPanel.add(currentPanel);
        test.add(viewPanel, BorderLayout.CENTER);

        //getMatList();// getter로 수정해야
        ObjSelectPage();

        setVisible(true);
    }

    // 임시
    private void getMatList()
    {
        /*mat1 = (MatObj) ObjList[0];
        mat2 = (MatObj) ObjList[1];
        mat3 = (MatObj) ObjList[2];
        mat4 = (MatObj) ObjList[3];

        MatList[0] = mat1;
        MatList[1] = mat2;
        MatList[2] = mat3;
        MatList[3] = mat4;*/
        MatList = MatObj.dataGetter();
    }

    private void ObjSelectPage()
    {
        objSelectPage = new B_ObjSelect();
        matBtn = new ButtonForm2("./image/Mat");
        ummBtn = new ButtonForm2("./image/Umm");
        medBtn = new ButtonForm2("./image/Med");

        matBtn.addActionListener(this);
        ummBtn.addActionListener(this);
        medBtn.addActionListener(this);

        objSelectPage.add(matBtn);
        objSelectPage.add(ummBtn);
        objSelectPage.add(medBtn);

        currentPanel.add(objSelectPage, BorderLayout.CENTER);
    }

    private void MatSelectPage()
    {
        matSelectPage = new B_MatSelect();

        getMatList();
        B_MatInfo mat1info = new B_MatInfo(MatList[0].getObjID(), MatList[0].getDateStart(),
                MatList[0].getDateHaveto(), MatList[0].getIsBorrowing());
        B_MatInfo mat2info = new B_MatInfo(MatList[1].getObjID(), MatList[1].getDateStart(),
                MatList[1].getDateHaveto(), MatList[1].getIsBorrowing());
        B_MatInfo mat3info = new B_MatInfo(MatList[2].getObjID(), MatList[2].getDateStart(),
                MatList[2].getDateHaveto(), MatList[2].getIsBorrowing());
        B_MatInfo mat4info = new B_MatInfo(MatList[3].getObjID(), MatList[3].getDateStart(),
                MatList[3].getDateHaveto(), MatList[3].getIsBorrowing());


        System.out.println(MatList[0].getIsBorrowing());
        System.out.println(MatList[1].getIsBorrowing());
        System.out.println(MatList[2].getIsBorrowing());
        System.out.println(MatList[3].getIsBorrowing());


        mat1Btn = new ButtonForm3(BorrowAble(MatList[0])); //isborrowing boolean function
        mat2Btn = new ButtonForm3(BorrowAble(MatList[1]));
        mat3Btn = new ButtonForm3(BorrowAble(MatList[2]));
        mat4Btn = new ButtonForm3(BorrowAble(MatList[3]));

        mat1Btn.addActionListener(this);
        mat2Btn.addActionListener(this);
        mat3Btn.addActionListener(this);
        mat4Btn.addActionListener(this);

        JPanel mat1Pane = new JPanel();
        mat1Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        mat1Pane.add(mat1info);
        mat1Pane.add(mat1Btn);

        JPanel mat2Pane = new JPanel();
        mat2Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        mat2Pane.add(mat2info);
        mat2Pane.add(mat2Btn);

        JPanel mat3Pane = new JPanel();
        mat3Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        mat3Pane.add(mat3info);
        mat3Pane.add(mat3Btn);

        JPanel mat4Pane = new JPanel();
        mat4Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        mat4Pane.add(mat4info);
        mat4Pane.add(mat4Btn);

        matSelectPage.add(mat1Pane);
        matSelectPage.add(mat2Pane);
        matSelectPage.add(mat3Pane);
        matSelectPage.add(mat4Pane);

        currentPanel.add(matSelectPage, BorderLayout.CENTER);
    }

    private void UmmSelectPage()
    {
        ummSelectPage = new B_UmmSelect();
        /*
        Date start = new Date(2022, 6, 1, 11, 30, 45);// startDate
        Date haveto = new Date(2022, 6, 2, 11, 00, 45);
        B_MatInfo mat1info = new B_MatInfo(1, start, haveto, false);
        B_MatInfo mat2info = new B_MatInfo(2, start, haveto, true);
        B_MatInfo mat3info = new B_MatInfo(3, start, haveto, false);
        B_MatInfo mat4info = new B_MatInfo(4, start, haveto, false);

        mat1Btn = new ButtonForm3("./image/BorrowAble"); // isborrowing boolean
        // function
        mat2Btn = new ButtonForm3("./image/BorrowUnable");
        mat3Btn = new ButtonForm3("./image/BorrowAble");
        mat4Btn = new ButtonForm3("./image/BorrowAble");
        */
        B_UmmInfo umm1info = new B_UmmInfo(mat1.getObjID(), mat1.getDateStart(),
                mat1.getDateHaveto(), mat1.getIsBorrowing());
        B_UmmInfo umm2info = new B_UmmInfo(mat2.getObjID(), mat2.getDateStart(),
                mat2.getDateHaveto(), mat2.getIsBorrowing());
        B_UmmInfo umm3info = new B_UmmInfo(mat3.getObjID(), mat3.getDateStart(),
                mat3.getDateHaveto(), mat3.getIsBorrowing());
        B_UmmInfo umm4info = new B_UmmInfo(mat4.getObjID(), mat4.getDateStart(),
                mat4.getDateHaveto(), mat4.getIsBorrowing());

        umm1Btn = new ButtonForm3(BorrowAble(umm1)); //isborrowing boolean function 
        umm2Btn = new ButtonForm3(BorrowAble(umm2));
        umm3Btn = new ButtonForm3(BorrowAble(umm3));
        umm4Btn = new ButtonForm3(BorrowAble(umm4));

        umm1Btn.addActionListener(this);
        umm2Btn.addActionListener(this);
        umm3Btn.addActionListener(this);
        umm4Btn.addActionListener(this);

        JPanel umm1Pane = new JPanel();
        umm1Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        umm1Pane.add(umm1info);
        umm1Pane.add(umm1Btn);

        JPanel umm2Pane = new JPanel();
        umm2Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        umm2Pane.add(umm2info);
        umm2Pane.add(umm2Btn);

        JPanel umm3Pane = new JPanel();
        umm3Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        umm3Pane.add(umm3info);
        umm3Pane.add(umm3Btn);

        JPanel umm4Pane = new JPanel();
        umm4Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        umm4Pane.add(umm4info);
        umm4Pane.add(umm4Btn);

        ummSelectPage.add(umm1Pane);
        ummSelectPage.add(umm2Pane);
        ummSelectPage.add(umm3Pane);
        ummSelectPage.add(umm4Pane);

        currentPanel.add(ummSelectPage, BorderLayout.CENTER);
    }

    private void MedSelectPage()
    {
        medSelectPage = new B_MedSelect();

        B_MedInfo med1info = new B_MedInfo("반창고", 9);
        B_MedInfo med2info = new B_MedInfo("파 스", 0);
        B_MedInfo med3info = new B_MedInfo("감기약", 7);

        med1Btn = new ButtonForm3("./image/BorrowAble"); // isborrowing boolean
        // function
        med2Btn = new ButtonForm3("./image/BorrowUnable");
        med3Btn = new ButtonForm3("./image/BorrowAble");

        med1Btn.addActionListener(this);
        med2Btn.addActionListener(this);
        med3Btn.addActionListener(this);

        JPanel med1Pane = new JPanel();
        med1Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        med1Pane.add(med1info);
        med1Pane.add(med1Btn);

        JPanel med2Pane = new JPanel();
        med2Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        med2Pane.add(med2info);
        med2Pane.add(med2Btn);

        JPanel med3Pane = new JPanel();
        med3Pane.setBackground(BGCOLOR);
        setLayout(new FlowLayout());
        med3Pane.add(med3info);
        med3Pane.add(med3Btn);

        medSelectPage.add(med1Pane);
        medSelectPage.add(med2Pane);
        medSelectPage.add(med3Pane);

        currentPanel.add(medSelectPage, BorderLayout.CENTER);
    }

    // Mat isBorrowing boolean function
    private String BorrowAble(BorrowObject obj)
    {
        String img;
        if (obj.getIsBorrowing())
        {
            img = "./image/BorrowAble";
            return img;
        }
        else
        {
            img = "./image/BorrowUnable";
            return img;
        }
    }

    private void BorrowPage(BorrowObject BObj)
    {
        borrowComfirmPage = new B_BorrowComfirm(BObj);
        OKComfirmBtn = new ButtonForm("./image/codeVerifyButton");
        OKComfirmBtn.addActionListener(this);

        borrowComfirmPage.add(OKComfirmBtn);

        currentPanel.add(borrowComfirmPage, BorderLayout.CENTER);
    }

    private void UsePage(String medname, int count)
    {// matobj로 바꿀것

        useComfirmPage = new B_UseComfirm(medname, count);
        MedOKComfirmBtn = new ButtonForm("./image/codeVerifyButton");
        MedOKComfirmBtn.addActionListener(this);

        useComfirmPage.add(MedOKComfirmBtn);

        currentPanel.add(useComfirmPage, BorderLayout.CENTER);
    }

    private void ReturnPage(BorrowObject BObj)
    {// matobj로 바꿀것
        returnPage = new B_ReturnPage(BObj);
        OKReturnBtn = new ButtonForm("./image/codeVerifyButton");
        OKReturnBtn.addActionListener(this);

        returnPage.add(OKReturnBtn);

        currentPanel.add(returnPage, BorderLayout.CENTER);
    }

    private void TermsPage(String filedirectory)
    {// 에베베
        termsPage = new Terms(filedirectory);

        JPanel BtnWrapper = new JPanel(new FlowLayout());
        BtnWrapper.setBackground(BGCOLOR);
        JPanel CheckWrapper = new JPanel(new FlowLayout());
        CheckWrapper.setBackground(BGCOLOR);

        if (filedirectory.equals("./data/MatTerms.txt"))
        {
            if (MatAgree)
            {
                MatAgreeBtn = new ButtonForm4("./image/Agreeclick");
            }
            else
            {
                MatAgreeBtn = new ButtonForm4("./image/Agree");
            }
            MatAgreeBtn.addActionListener(this);

            MatOKTermsBtn = new ButtonForm("./image/codeVerifyButton");
            MatOKTermsBtn.addActionListener(this);
            if (!MatAgree)
            {
                MatOKTermsBtn.setEnabled(false);
            }
            CheckWrapper.add(MatAgreeBtn);
            BtnWrapper.add(MatOKTermsBtn);
        }
        else if (filedirectory.equals("./data/MedTerms.txt"))
        {
            if (MedAgree)
            {
                MedAgreeBtn = new ButtonForm4("./image/Agreeclick");
            }
            else
            {
                MedAgreeBtn = new ButtonForm4("./image/Agree");
            }
            MedAgreeBtn.addActionListener(this);

            MedOKTermsBtn = new ButtonForm("./image/codeVerifyButton");
            MedOKTermsBtn.addActionListener(this);
            if (!MedAgree)
            {
                MedOKTermsBtn.setEnabled(false);
            }
            CheckWrapper.add(MedAgreeBtn);
            BtnWrapper.add(MedOKTermsBtn);
        }

        JPanel Wrapper = new JPanel(new GridLayout(2, 1));
        Wrapper.setBackground(BGCOLOR);

        Wrapper.add(CheckWrapper);
        Wrapper.add(BtnWrapper);
        termsPage.add(Wrapper);
        termsPage.setPreferredSize(new Dimension(500, 990));

        currentPanel.add(termsPage);
    }

    private void ReturnGuidePage()
    {
        returnguidePage = new B_ReturnGuidePage();

        if (MatAgreeR)
        {
            MatAgreeRBtn = new ButtonForm4("./image/Agreeclick");
        }
        else
        {
            MatAgreeRBtn = new ButtonForm4("./image/Agree");
        }
        MatAgreeRBtn.addActionListener(this);

        OKReturnGuideBtn = new ButtonForm("./image/codeVerifyButton");
        OKReturnGuideBtn.addActionListener(this);
        if (!MatAgreeR)
        {
            OKReturnGuideBtn.setEnabled(false);
        }
        JPanel Wrapper = new JPanel(new GridLayout(2, 1));
        Wrapper.setBackground(BGCOLOR);
        JPanel W2 = new JPanel(new FlowLayout());
        W2.setBackground(BGCOLOR);
        W2.add(MatAgreeRBtn);
        Wrapper.add(W2);
        JPanel W1 = new JPanel(new FlowLayout());
        W1.setBackground(BGCOLOR);

        W1.add(OKReturnGuideBtn);
        Wrapper.add(W1);
        returnguidePage.add(Wrapper);
        returnguidePage.setPreferredSize(new Dimension(500, 990));

        currentPanel.add(returnguidePage);
    }

    private void CompletePage(String completej)//, BorrowObject borrowOb
    {// obj 받기->Haveto date 받기
        completePage = new CompletePage(completej);//, borrowObj
        gotoMainBtn = new ButtonForm("./image/gotoMainButton");
        gotoMainBtn.addActionListener(this);

        completePage.add(gotoMainBtn);

        currentPanel.add(completePage, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        currentPanel.removeAll();

        if (e.getSource() == matBtn)
        {
            MatSelectPage();
        }
        if (e.getSource() == ummBtn)
        {
            UmmSelectPage();
        }
        if (e.getSource() == medBtn)
        {
            MedSelectPage();
        }
        if (e.getSource() == mat1Btn)
        {
            boolean borrowing = false;//objisborrowing
            if (borrowing)
            {
                ReturnPage(mat1);//objID
            }
            else
            {
                BorrowPage(mat1);
            }
        }
        if (e.getSource() == mat2Btn)
        {
            boolean borrowing = true;//objisborrowing
            if (borrowing)
            {
                ReturnPage(mat2);//objID
            }
            else
            {
                BorrowPage(mat2);
            }
        }
        if (e.getSource() == mat3Btn)
        {
            boolean borrowing = false;//objisborrowing
            if (borrowing)
            {
                ReturnPage(mat3);//objID
            }
            else
            {
                BorrowPage(mat3);
            }
        }
        if (e.getSource() == mat4Btn)
        {
            boolean borrowing = false;//objisborrowing
            if (borrowing)
            {
                ReturnPage(mat4);//objID
            }
            else
            {
                BorrowPage(mat4);
            }
        }
        if (e.getSource() == umm1Btn)
        {
            boolean borrowing = false;//objisborrowing
            if (borrowing)
            {
                ReturnPage(umm1);//objID
            }
            else
            {
                BorrowPage(umm1);
            }
        }
        if (e.getSource() == umm2Btn)
        {
            boolean borrowing = true;//objisborrowing
            if (borrowing)
            {
                ReturnPage(umm2);//objID
            }
            else
            {
                BorrowPage(umm2);
            }
        }
        if (e.getSource() == umm3Btn)
        {
            boolean borrowing = false;//objisborrowing
            if (borrowing)
            {
                ReturnPage(umm3);//objID
            }
            else
            {
                BorrowPage(umm3);
            }
        }
        if (e.getSource() == umm4Btn)
        {
            boolean borrowing = false;//objisborrowing
            if (borrowing)
            {
                ReturnPage(umm4);//objID
            }
            else
            {
                BorrowPage(umm4);
            }
        }
        if (e.getSource() == OKComfirmBtn)
        {
            TermsPage("./data/MatTerms.txt");
        }
        if (e.getSource() == OKReturnBtn)
        {
            ReturnGuidePage();
        }
        if (e.getSource() == MatAgreeBtn)
        {
            MatAgree = !MatAgree;
            TermsPage("./data/MatTerms.txt");
        }
        if (e.getSource() == MatAgreeRBtn)
        {
            MatAgreeR = !MatAgreeR;
            ReturnGuidePage();
        }
        if (e.getSource() == MatOKTermsBtn)
        {
            CompletePage("borrowComplete");
        }
        if (e.getSource() == OKReturnGuideBtn)
        {
            CompletePage("returnComplete");
        }

        if (e.getSource() == med1Btn)
        {
            UsePage("반창고", 9);
        }
        if (e.getSource() == med2Btn)
        {
            UsePage("파 스", 0);
        }
        if (e.getSource() == med3Btn)
        {
            UsePage("감기약", 7);
        }
        if (e.getSource() == MedOKComfirmBtn)
        {
            TermsPage("./data/MedTerms.txt");
        }
        if (e.getSource() == MedOKTermsBtn)
        {
            CompletePage("UseMedComplete");
        }
        if (e.getSource() == MedAgreeBtn)
        {
            MedAgree = !MedAgree;
            TermsPage("./data/MedTerms.txt");
        }
        if (e.getSource() == gotoMainBtn)
        {
            KioskMain k = new KioskMain();
            k.setVisible(true);
            setVisible(false);
        }

        currentPanel.updateUI();
    }

}
