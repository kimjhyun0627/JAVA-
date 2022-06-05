package TeamProject;

import java.awt.*;

import javax.swing.*;

public class B_BorrowComfirm extends JPanel{
	
	public B_BorrowComfirm(BorrowObject Bobj) {////obj로 바꿀것
		// TODO Auto-generated constructor stub
		super();
		setBackground(BorrowMain.BGCOLOR);
		setLayout(new GridLayout(5,1));
		
		centerBoldLabel title = new centerBoldLabel("대여 정보 확인", 42);
		
		JPanel cp = new JPanel();
        cp.setLayout(new GridLayout(6,2));
        cp.setBackground(BorrowMain.BGCOLOR);
        
        String obj = null;//object type setting
        if(Bobj instanceof MatObj){
        	obj = "돗자리";
        }else if(Bobj instanceof UmmObj){
        	obj = "우산";
        }
        
        JLabel nObjLB = new JLabel(Bobj.objID+"번 "+obj+" 대여");//자녀class판단필요
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
		//JLabel dateh = new JLabel("~ "+Bobj.getDateHaveto().toString());
		
        //임시
        Date datestart = new Date(Bobj.dateStart);
        Date datehaveto = new Date(Bobj.dateHaveto);
        JLabel dates = new JLabel(datestart.toString());
		JLabel dateh = new JLabel("~ "+datehaveto.toString());
        dates.setFont(new Font("IM혜민 regular", Font.PLAIN, 24));
		dateh.setFont(new Font("IM혜민 regular", Font.PLAIN, 24));
		
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
        cp.add(dateh);
        cp.add(nameLB);
        cp.add(name);
        cp.add(sIDLB);
        cp.add(sID);
        cp.add(phoneLB);
        cp.add(phone);
        
		//add(new EmptyPanel());
        add(title);
		add(cp);
		add(correct);
	}

}
