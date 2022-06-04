package TeamProject;

import java.awt.*;

import javax.swing.*;

public class CompletePage extends JPanel{
	public CompletePage(String complete){
		 super();
	     setBackground(BorrowMain.BGCOLOR);
	     setLayout(new GridLayout(8, 1));
	     
	     if(complete.equals("borrowComplete")){
	    	 centerBoldLabel title = new centerBoldLabel("대여 완료", 42);
		     
		     Date dateHaveto = new Date(2022,6,4,11,15,5);
		     JLabel HavetoGuide = new JLabel(dateHaveto.toString()+"까지 반납입니다.");
		     HavetoGuide.setFont(new Font("IM혜민 regular", Font.PLAIN, 24));
		     HavetoGuide.setForeground(Color.RED);
		     
		     //카운터
		     
		     add(new EmptyPanel());
		     add(title);
		     add(new EmptyPanel());
		     add(HavetoGuide);
		     add(new EmptyPanel());
		     add(new EmptyPanel());
	     }else if(complete.equals("returnComplete")){
	    	 centerBoldLabel title = new centerBoldLabel("반납 완료", 42);
		     
		     //카운터
		     
		     add(new EmptyPanel());
		     add(title);
		     add(new EmptyPanel());
		     add(new EmptyPanel());
		     add(new EmptyPanel());
		     add(new EmptyPanel());
	     }
	     
	     
	        
	}

}
