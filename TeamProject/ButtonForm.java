package TeamProject;

import javax.swing.*;
import java.awt.*;

public class ButtonForm extends JButton
{
    public ButtonForm(String imgPath)
    {
        super();
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);

        ImageIcon imgIcon = new ImageIcon(imgPath+".png");
        ImageIcon imgIconDark = new ImageIcon(imgPath+"_dark.png");

        Image img = imgIcon.getImage();
        Image imgDark = imgIconDark.getImage();
        img = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        imgDark = imgDark.getScaledInstance(200, 100, Image.SCALE_SMOOTH);

        imgIcon.setImage(img);
        imgIconDark.setImage(imgDark);

        setIcon(imgIcon);
        setRolloverIcon(imgIconDark);
    }
}
