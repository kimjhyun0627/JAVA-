package TeamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
public class KioskMain extends JFrame implements ActionListener{
	public static final JPanel currentPanel = new JPanel();
	public static final Color BGCOLOR = new Color(0xededf9);
	private JButton borrowBtn;
	private JButton cabinetBtn;
	private JButton settingBtn;
	//영랑 언니가 만든 이름으로 수정
	private exBorrowMain borrowPage;
	private exPasswordMain cabinetPage;
	private ChangePage changePage;
	private kioskmain_into mainPage;
	
	public static void main(String[] args) {
		KioskMain k = new KioskMain();
		k.setVisible(true);
		return;
	}
	
	public KioskMain() {
		super("Kiosk Main");
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
		
		kioskPage();
		
		setVisible(true);
	}
	
	private void showLastPage() {
		
	}
	
	private void kioskPage() {
		
		mainPage = new kioskmain_into();
		
		borrowBtn = new ButtonForm_large("./image/ObjBorrow");
		borrowBtn.addActionListener(this);
		
		cabinetBtn = new ButtonForm_large("./image/FindPassword");
		cabinetBtn.addActionListener(this);
		
		settingBtn = new ButtonForm("./image/mailSubmitButton");
		settingBtn.addActionListener(this);
		
		mainPage.add(borrowBtn);
		mainPage.add(cabinetBtn);
		mainPage.add(settingBtn);
		
		currentPanel.add(mainPage, BorderLayout.CENTER);
	}
	
	private void showChangePage(String errorMSG) {
		changePage = new ChangePage(errorMSG);
		currentPanel.add(changePage);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		currentPanel.removeAll();
		
		if(e.getSource() == borrowBtn) {
			//showChangePage("");
		}
		if(e.getSource() == cabinetBtn) {
			//showChangePage("");
		}
		if(e.getSource() == borrowBtn) {
			//showChangePage("");
		}
		
		currentPanel.updateUI();
	}
}
*/










