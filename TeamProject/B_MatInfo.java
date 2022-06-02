package TeamProject;
import javax.swing.*;

import java.awt.*;
public class B_MatInfo extends JPanel{
	public B_MatInfo(int num, Date datestart, boolean isborrowing){
		super();
        setLayout(new GridLayout(3,1));
        setBackground(BorrowMain.BGCOLOR);
        
		if(isborrowing){
			//print matname
			centerBoldLabel title = new centerBoldLabel(num+"번 돗자리 : 대여가능     ", 30);
			add(title);
		}else{
			//print matname
			centerBoldLabel title = new centerBoldLabel(num+"번 돗자리 : 대여불가     ", 30);
			//print date
			String startDate = datestart.toString();
			Date Datehaveto = new Date();
			Datehaveto.setDate(datestart.getYear(),
					datestart.getMonth(), 
					datestart.getDay()+1, 
					datestart.getHour(), 
					datestart.getMinute(),
					datestart.getSecond());
			String havetoDate = Datehaveto.toString();
			JLabel dates = new JLabel(startDate);
			JLabel datee = new JLabel("~"+havetoDate);
			//JLabel blank = new JLabel(" ");
			dates.setFont(new Font("IM혜민 regular", Font.PLAIN, 24));
			datee.setFont(new Font("IM혜민 regular", Font.PLAIN, 24));
			//blank.setFont(new Font("IM혜민 regular", Font.PLAIN, 12));
			
			add(title);
			add(dates);
			add(datee);
			//add(blank);
		}
		
		
	}
}
/*Date havetoDate = new Date();
havetoDate.setDate(datestart.getYear(),
datestart.getMonth(), 
datestart.getDay()+1, 
datestart.getHour(), 
datestart.getMinute(),
datestart.getSecond());*/