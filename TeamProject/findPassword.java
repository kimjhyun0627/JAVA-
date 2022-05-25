package TeamProject;

import javax.swing.*;
import java.awt.*;

public class findPassword extends JPanel
{
    public findPassword()
    {
        super();
        setLayout(new GridLayout(10, 1));
        setBackground(PasswordMain.BGCOLOR);

        JLabel title1 = new titleLabel("김진현" + " 님의", 42);
        JLabel title2 = new titleLabel("사물함 조회 내역입니다", 42);
        JLabel cabID = new JLabel("사물함 번호 - " + 82);
        JLabel cabPW = new JLabel("사물함 비밀번호 - " + 1234);
        cabID.setFont(new Font("IM혜민 regular", Font.PLAIN, 24));
        cabPW.setFont(new Font("IM혜민 regular", Font.PLAIN, 24));

        add(title1);
        add(title2);
        add(new EmptyPanel());
        add(cabID);
        add(cabPW);
        add(new EmptyPanel());
    }
}
