package TeamProject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton BorrowY;
	private JButton BorrowN;
	private JButton YBtn;
	private JButton NBtn;
	private JButton OKBtn;
	private JButton gotoMainBtn;
	private JButton backBtn;
	private JButton checkBtn;
	private B_infoPage infoPage;
	private B_ObjSelect objSelectPage;
	private B_MatSelect matSelectPage;
	//private JPanel matSelectPage;
	private JPanel matSelectinfo;
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BorrowMain b = new BorrowMain();
		b.setVisible(true);
		return;

	}

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

		userinfoPage(0,"", "","");

		setVisible(true);
	}

	private void userinfoPage(int errorCode, String name, String ID, String phone) {
		// TODO Auto-generated method stub
		String errorStr = "";

		if (errorCode == 1) {
			errorStr += "등록되지 않은 이용자입니다";
		} else if (errorCode == 0) {
			errorStr += "";
		} else if (errorCode == -1) {
			errorStr += "정보을 모두 입력해주세요";
		} else if (errorCode == -2) {
			errorStr += "학번을 다시 입력해주세요";
		} else if (errorCode == -3) {
			errorStr += "전화번호을 다시 입력해주세요";
		} else {
			errorStr += "알 수 없는 오류입니다";
		}

		infoPage = new B_infoPage(errorStr, name, ID, phone);

		userinfosubmitBtn = new ButtonForm("./image/mailSubmitButton");
		userinfosubmitBtn.addActionListener(this);

		infoPage.add(userinfosubmitBtn);

		currentPanel.add(infoPage, BorderLayout.CENTER);
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
		
        Date start = new Date(2022, 1, 1, 11, 30, 45);//startDate
        B_MatInfo mat1info = new B_MatInfo(1, start, true);
        B_MatInfo mat2info = new B_MatInfo(2, start, false);
        B_MatInfo mat3info = new B_MatInfo(3, start, true);
        B_MatInfo mat4info = new B_MatInfo(4, start, true);
        
		mat1Btn = new ButtonForm3("./image/BorrowAble"); //isborrowing boolean function
		mat2Btn = new ButtonForm3("./image/BorrowUnable");
		mat3Btn = new ButtonForm3("./image/BorrowAble");
		mat4Btn = new ButtonForm3("./image/BorrowAble");
		
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
	
	//Mat isBorrowing boolean function


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		currentPanel.removeAll();

		if (e.getSource() == userinfosubmitBtn) {
			String name = infoPage.getName();
			String id = infoPage.getID();
			String phone = infoPage.getPhone();

			if (id.equals("2020113714") && !name.isEmpty() && !phone.isEmpty()
					&& id.length() == 10 && phone.length() == 11) {
				ObjSelectPage();
			} else if (name.length() == 0 || id.length() == 0
					|| phone.length() == 0) {
				userinfoPage(-1, name, id, phone);
			} else if (id.length() != 10) {
				userinfoPage(-2, name, id, phone);
			} else if (phone.length() != 11) {
				userinfoPage(-3, name, id, phone);
			} else {
				userinfoPage(1, name, id, phone);
			}
		}
		if(e.getSource()==matBtn){
			MatSelectPage();
			//System.out.print("mat");
			
		}
		if(e.getSource()==ummBtn){
			
		}
		if(e.getSource()==medBtn){
			
		}
		
		
		currentPanel.updateUI();
	}

	

	
}
