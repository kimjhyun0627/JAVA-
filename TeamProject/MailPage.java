package TeamProject;

import java.awt.*;
import javax.swing.*;

public class MailPage extends JPanel
{
    public static final int MAIL_LENGTH = 15;
    private JTextField mailInput;

    public MailPage(String errorMSG)
    {
        super();
        setBackground(PasswordMain.BGCOLOR);
        setLayout(new GridLayout(8, 1));

        titleLabel title = new titleLabel("KNU 웹메일을 입력해주세요", 42);

        add(new EmptyPanel());
        add(title);
        add(new EmptyPanel());

        mailInput = new JTextField(MAIL_LENGTH);
        mailInput.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));
        JLabel Domain = new JLabel(" @knu.ac.kr");
        Domain.setFont(new Font("IM혜민 regular", Font.PLAIN, 30));

        JPanel mailAddressPanel = new JPanel(new FlowLayout());
        mailAddressPanel.setBackground(PasswordMain.BGCOLOR);
        mailAddressPanel.add(mailInput);
        mailAddressPanel.add(Domain);

        JLabel errorMSGLabel = new errorMSGLabel(errorMSG);

        JPanel mailAddressWrapperPanel = new JPanel(new GridLayout(2, 1));
        mailAddressWrapperPanel.setBackground(PasswordMain.BGCOLOR);
        mailAddressWrapperPanel.add(mailAddressPanel);
        mailAddressWrapperPanel.add(errorMSGLabel);

        add(mailAddressWrapperPanel);
        add(new EmptyPanel());
        add(new EmptyPanel());
        add(new EmptyPanel());

        setVisible(true);
    }

    public String getMailAddress()
    {
        return mailInput.getText();
    }

}