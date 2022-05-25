package TeamProject;

import javax.swing.*;
import java.awt.*;

public class CodeVerifyPage extends JPanel
{
    private JTextField codeInput;

    public CodeVerifyPage(String errorMSG)
    {
        super();
        setLayout(new GridLayout(6, 1));
        setBackground(PasswordMain.BGCOLOR);

        JLabel title = new titleLabel("4자리 인증코드를 입력해주세요", 42);

        add(new EmptyPanel());
        add(title);
        add(new EmptyPanel());

        codeInput = new JTextField(4);
        codeInput.setFont(new Font("IM혜민 regular", Font.PLAIN, 48));

        JPanel codeVerifyPanel = new JPanel(new FlowLayout());
        codeVerifyPanel.setBackground(PasswordMain.BGCOLOR);
        codeVerifyPanel.add(codeInput);

        JLabel errorMSGLabel = new errorMSGLabel(errorMSG);

        JPanel codeVerifyWrapperPanel = new JPanel(new GridLayout(2, 1));
        codeVerifyWrapperPanel.setBackground(PasswordMain.BGCOLOR);
        codeVerifyWrapperPanel.add(codeVerifyPanel);
        codeVerifyWrapperPanel.add(errorMSGLabel);

        add(codeVerifyWrapperPanel);
        add(new EmptyPanel());

        setVisible(true);
    }

    public String getCodeInput()
    {
        return codeInput.getText();
    }
}