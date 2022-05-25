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

        ImageIcon mailSubmitIcon = new ImageIcon(imgPath);

        Image mailSubmitImg = mailSubmitIcon.getImage();
        mailSubmitImg = mailSubmitImg.getScaledInstance(200, 100, Image.SCALE_SMOOTH);

        mailSubmitIcon.setImage(mailSubmitImg);

        setIcon(mailSubmitIcon);
    }
}
