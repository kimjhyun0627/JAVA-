package TeamProject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BorrowMain extends JFrame implements ActionListener {
	public static final JPanel currentPanel = new JPanel();
	public static final Color BGCOLOR = new Color(0xededf9);
	private JButton userinfosubmitBtn;
	private JButton matBtn;
	private JButton mat1Btn;
	private JButton mat2Btn;
	private JButton mat3Btn;
	private JButton mat4Btn;
	private JButton ummBtn;
	private JButton medBtn;
	private JButton OKComfirmBtn;
	private JButton OKReturnBtn;
	private JButton agreeBtn;
	private JButton agreeRBtn;
	private JButton OKTermsBtn;
	private JButton OKReturnGuideBtn;
	private JButton gotoMainBtn;
	private ArrayList<B_MatObj> MatList = new ArrayList<B_MatObj>();
	private B_MatObj mat1;
	private B_MatObj mat2;
	private B_MatObj mat3;
	private B_MatObj mat4;
	private B_infoPage infoPage;
	private B_ObjSelect objSelectPage;
	private B_MatSelect matSelectPage;
	// private JPanel matSelectPage;
	private JPanel matSelectinfo;
	private B_BorrowComfirm borrowComfirmPage;
	private B_ReturnPage returnPage;
	private Terms termsPage;
	private B_ReturnGuidePage returnguidePage;
	private CompletePage completePage;
	private boolean agree = false;
	private boolean agreeR = false;
	

	public static void main(String[] args) {
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

	public BorrowMain() {
		super("test");
		setSize(660, 990);
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

		ObjSelectPage();
		//userinfoPage(0,"", "","");
		//TermsPage();
		// getter로 수정해야

		setVisible(true);
	}

	// 임시
	private void getMatList() {
		mat1 = new B_MatObj(1, new Date(2022, 6, 3, 12, 30, 10), new Date(2022,
				6, 4, 11, 15, 5), "2021111111");
		mat2 = new B_MatObj(2, new Date(2022, 6, 4, 12, 30, 10), new Date(2022,
				6, 4, 11, 15, 5), "2021111111");
		mat3 = new B_MatObj(3, new Date(2022, 6, 2, 12, 30, 10), new Date(2022,
				6, 3, 11, 15, 5), "2021111111");
		mat4 = new B_MatObj(4, new Date(2022, 5, 31, 12, 30, 10), new Date(
				2022, 6, 1, 11, 15, 5), "2021111111");

		MatList.add(mat1);
		MatList.add(mat2);
		MatList.add(mat3);
		MatList.add(mat4);
	}
	
	private void ObjSelectPage() {
		// TODO Auto-generated method stub
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

	private void MatSelectPage() {
		// TODO Auto-generated method stub

		matSelectPage = new B_MatSelect();

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
		/*
		 * B_MatInfo mat1info = new B_MatInfo(mat1.getID(), mat1.getDateStart(),
		 * mat1.getDateHaveto(), mat1.getIsBorrowing()); B_MatInfo mat2info =
		 * new B_MatInfo(mat2.getID(), mat2.getDateStart(),
		 * mat2.getDateHaveto(), mat2.getIsBorrowing()); B_MatInfo mat3info =
		 * new B_MatInfo(mat3.getID(), mat3.getDateStart(),
		 * mat3.getDateHaveto(), mat3.getIsBorrowing()); B_MatInfo mat4info =
		 * new B_MatInfo(mat4.getID(), mat4.getDateStart(),
		 * mat4.getDateHaveto(), mat4.getIsBorrowing());
		 * 
		 * mat1Btn = new ButtonForm3(BorrowAble(mat1)); //isborrowing boolean
		 * function mat2Btn = new ButtonForm3(BorrowAble(mat2)); mat3Btn = new
		 * ButtonForm3(BorrowAble(mat3)); mat4Btn = new
		 * ButtonForm3(BorrowAble(mat4));
		 */
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

	// Mat isBorrowing boolean function
	private String BorrowAble(B_MatObj mat) {
		String img;
		if (mat.getIsBorrowing()) {
			img = "./image/BorrowUnable";
			return img;
		} else {
			img = "./image/BorrowAble";
			return img;
		}
	}

	private void BorrowPage(int matObj) {// matobj로 바꿀것

		borrowComfirmPage = new B_BorrowComfirm(matObj);
		OKComfirmBtn = new ButtonForm("./image/codeVerifyButton");
		OKComfirmBtn.addActionListener(this);

		borrowComfirmPage.add(OKComfirmBtn);

		currentPanel.add(borrowComfirmPage, BorderLayout.CENTER);
	}
	
	private void ReturnPage(int matObj){// matobj로 바꿀것
		returnPage = new B_ReturnPage(matObj);
		OKReturnBtn = new ButtonForm("./image/codeVerifyButton");
		OKReturnBtn.addActionListener(this);

		returnPage.add(OKReturnBtn);

		currentPanel.add(returnPage, BorderLayout.CENTER);
	}

	private void TermsPage() {// 에베베
		termsPage = new Terms();

		if (agree) {
			agreeBtn = new ButtonForm4("./image/Agreeclick");
		} else {
			agreeBtn = new ButtonForm4("./image/Agree");
		}
		agreeBtn.addActionListener(this);

		OKTermsBtn = new ButtonForm("./image/codeVerifyButton");
		OKTermsBtn.addActionListener(this);
		if(!agree)
		{
			OKTermsBtn.setEnabled(false);
		}
		JPanel Wrapper = new JPanel(new GridLayout(2, 1));
		Wrapper.setBackground(BGCOLOR);
		JPanel W2 = new JPanel(new FlowLayout());
		W2.setBackground(BGCOLOR);
		W2.add(agreeBtn);
		Wrapper.add(W2);
		JPanel W1 = new JPanel(new FlowLayout());
		W1.setBackground(BGCOLOR);
		
		W1.add(OKTermsBtn);
		Wrapper.add(W1);
		termsPage.add(Wrapper);
		termsPage.setPreferredSize(new Dimension(500,990));

		currentPanel.add(termsPage);
	}
	
	private void ReturnGuidePage(){
		returnguidePage = new B_ReturnGuidePage();
		
		if (agreeR) {
			agreeRBtn = new ButtonForm4("./image/Agreeclick");
		} else {
			agreeRBtn = new ButtonForm4("./image/Agree");
		}
		agreeRBtn.addActionListener(this);

		OKReturnGuideBtn = new ButtonForm("./image/codeVerifyButton");
		OKReturnGuideBtn.addActionListener(this);
		if(!agreeR)
		{
			OKReturnGuideBtn.setEnabled(false);
		}
		JPanel Wrapper = new JPanel(new GridLayout(2, 1));
		Wrapper.setBackground(BGCOLOR);
		JPanel W2 = new JPanel(new FlowLayout());
		W2.setBackground(BGCOLOR);
		W2.add(agreeRBtn);
		Wrapper.add(W2);
		JPanel W1 = new JPanel(new FlowLayout());
		W1.setBackground(BGCOLOR);
		
		W1.add(OKReturnGuideBtn);
		Wrapper.add(W1);
		returnguidePage.add(Wrapper);
		returnguidePage.setPreferredSize(new Dimension(500,990));

		currentPanel.add(returnguidePage);
	}

	private void CompletePage(String complete) {// obj 받기->Haveto date 받기
		completePage = new CompletePage(complete);
		gotoMainBtn = new ButtonForm("./image/gotoMainButton");
		gotoMainBtn.addActionListener(this);

		completePage.add(gotoMainBtn);

		currentPanel.add(completePage, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		currentPanel.removeAll();

		if (e.getSource() == matBtn) {
			MatSelectPage();
			

		}
		if (e.getSource() == ummBtn) {

		}
		if (e.getSource() == medBtn) {

		}
		if (e.getSource() == mat1Btn) {
			// B_MatObj mat = new B_MatObj(1, new Date(2022,6,3,12,30,10), new
			// Date(2022,6,4,11,15,5), "2021111111");
			boolean borrowing = false;//objisborrowing
			if(borrowing){
				ReturnPage(1);//objID
			}else{
				BorrowPage(1);
			}
		}
		if (e.getSource() == mat2Btn) {
			// B_MatObj mat = new B_MatObj(1, new Date(2022,6,3,12,30,10), new
			// Date(2022,6,4,11,15,5), "2021111111");
			boolean borrowing = true;//objisborrowing
			if(borrowing){
				ReturnPage(2);//objID
			}else{
				BorrowPage(2);
			}
		}
		if (e.getSource() == mat3Btn) {
			// B_MatObj mat = new B_MatObj(1, new Date(2022,6,3,12,30,10), new
			// Date(2022,6,4,11,15,5), "2021111111");
			boolean borrowing = false;//objisborrowing
			if(borrowing){
				ReturnPage(3);//objID
			}else{
				BorrowPage(3);
			}
		}
		if (e.getSource() == mat4Btn) {
			// B_MatObj mat = new B_MatObj(1, new Date(2022,6,3,12,30,10), new
			// Date(2022,6,4,11,15,5), "2021111111");
			boolean borrowing = false;//objisborrowing
			if(borrowing){
				ReturnPage(4);//objID
			}else{
				BorrowPage(4);
			}
		}
		if (e.getSource() == OKComfirmBtn) {
			TermsPage();
		}
		if (e.getSource() == OKReturnBtn){
			ReturnGuidePage();
		}
		if (e.getSource() == agreeBtn) {
			agree = !agree;
			TermsPage();
		}
		if (e.getSource() == agreeRBtn) {
			agreeR = !agreeR;
			ReturnGuidePage();
		}
		if (e.getSource() == OKTermsBtn) {
			CompletePage("borrowComplete");
		}
		if (e.getSource() == OKReturnGuideBtn) {
			CompletePage("returnComplete");
		}

		currentPanel.updateUI();
	}

}
