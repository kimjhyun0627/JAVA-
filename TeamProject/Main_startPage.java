package TeamProject;

import java.awt.*;
import javax.swing.*;

public class Main_startPage extends JPanel
{
    public Main_startPage()
    {
        super();
        setBackground(new Color(255,255,255,0));
        setLayout(new GridLayout(8, 1));

        centerBoldLabel title = new centerBoldLabel("학생회 키오스크", 72);

        add(new EmptyPanel());
        add(title);
        add(new EmptyPanel());
        add(new EmptyPanel());
        add(new EmptyPanel());
        add(new EmptyPanel());

    }
}
