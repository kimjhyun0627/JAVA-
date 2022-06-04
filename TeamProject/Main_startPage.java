package TeamProject;

import java.awt.*;
import javax.swing.*;

public class Main_startPage extends JPanel{
	
	public Main_startPage() {
		super();
        setBackground(BorrowMain.BGCOLOR);
        setLayout(new GridLayout(8, 1));

        centerBoldLabel title = new centerBoldLabel("학생회 키오스크", 72);
        
        //cse 이미지 넣기
        //ImageIcon cseIcon = new ImageIcon("./image/CSElogo.png").getImage();
        
        add(new EmptyPanel());
        add(title);
    
        add(new EmptyPanel());
        
	}
}
