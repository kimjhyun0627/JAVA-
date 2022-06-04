package TeamProject;

import java.awt.*;

import javax.swing.*;

public class B_BorrowComfirm extends JPanel{
	
	public B_BorrowComfirm(int Bobj) {////obj로 바꿀것
		// TODO Auto-generated constructor stub
		super();
		setBackground(BorrowMain.BGCOLOR);
		setLayout(new GridLayout(5,1));
		
		centerBoldLabel title = new centerBoldLabel("대여 정보 확인", 42);
		
		JPanel cp = new JPanel();
        cp.setLayout(new GridLayout(6,2));
        cp.setBackground(BorrowMain.BGCOLOR);
		/*
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
		//gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;*/

        //centerBoldLabel title = new centerBoldLabel("대여 정보 확인", 42);
        JLabel nObjLB = new JLabel(Bobj+"번 돗자리 대여");//자녀class판단필요
        nObjLB.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        JLabel termLB = new JLabel("대여기간 :");
        termLB.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        JLabel nameLB = new JLabel("이름 :");
        nameLB.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        JLabel sIDLB = new JLabel("학번 :");
        sIDLB.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        JLabel phoneLB = new JLabel("전화번호 :");
        phoneLB.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        JLabel correct = new JLabel("물품을 대여하시겠습니까?");
        correct.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        correct.setBackground(BorrowMain.BGCOLOR);
        
        //JLabel dates = new JLabel(Bobj.getDateStart().toString());
		//JLabel datee = new JLabel("~ "+Bobj.getDateHaveto().toString());
		
        //임시
        Date datestart = new Date(2022,6,3,12,30,10);
        Date dateend = new Date(2022,6,4,11,15,5);
        JLabel dates = new JLabel(datestart.toString());
		JLabel datee = new JLabel("~ "+dateend.toString());
        dates.setFont(new Font("IM혜민 regular", Font.PLAIN, 24));
		datee.setFont(new Font("IM혜민 regular", Font.PLAIN, 24));
		
		JLabel name = new JLabel("홍길동");//student에서 받기
        name.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        JLabel sID = new JLabel("1234567890");//student에서 받기
        sID.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        JLabel phone = new JLabel("01055555555");//student에서 받기
        phone.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        
        cp.add(nObjLB);
        cp.add(new EmptyPanel());
        cp.add(termLB);
        cp.add(dates);
        cp.add(new EmptyPanel());
        cp.add(datee);
        cp.add(nameLB);
        cp.add(name);
        cp.add(sIDLB);
        cp.add(sID);
        cp.add(phoneLB);
        cp.add(phone);

        //title
        /*
        gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		cp.add(title, gbc);
        //
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		cp.add(nObjLB, gbc);
        //
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		cp.add(termLB, gbc);
        //
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		cp.add(dates, gbc);
        //
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		cp.add(datee, gbc);
        //
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		cp.add(nameLB, gbc);
        //
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		cp.add(name, gbc);
        //
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		cp.add(sIDLB, gbc);
        //
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		cp.add(sID, gbc);
        //
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		cp.add(phoneLB, gbc);
        //
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		cp.add(phone, gbc);
        //
		gbc.gridx = 0;
		gbc.gridy =12;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		cp.add(correct, gbc);
		*/
		
		//add(new EmptyPanel());
        add(title);
		add(cp);
		add(correct);
	}

}
