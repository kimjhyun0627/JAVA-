package TeamProjectByTerminal;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mailPage extends JFrame implements ActionListener
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;
    public static final int MAIL_LENGTH = 15;
    public static final String MAIL_DOMAIN = "@knu.ac.kr";
    private JPanel titleWrapperPanel;
    private JLabel title;
    private JPanel mailWrapperPanel;
    private JTextField mailInput;
    private String mailAddress;
    private JPanel SubmitWrapperPanel;
    private JButton SubmitBtn;

    public static void main(String[] args)
    {
        mailPage t = new mailPage();
    }

    public mailPage()
    {
        super("TeamProject");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleWrapperPanel = new JPanel(new FlowLayout());
        title = new JLabel("Please input KNU web mail address");
        titleWrapperPanel.add(title);
        add(titleWrapperPanel, BorderLayout.NORTH);

        mailWrapperPanel = new JPanel(new FlowLayout());
        mailInput = new JTextField(MAIL_LENGTH);
        JLabel Domain = new JLabel(MAIL_DOMAIN);
        mailWrapperPanel.add(mailInput);
        mailWrapperPanel.add(Domain);
        add(mailWrapperPanel, BorderLayout.CENTER);

        SubmitWrapperPanel = new JPanel(new FlowLayout());
        SubmitBtn = new JButton("send configure code");
        SubmitBtn.addActionListener(this);
        SubmitWrapperPanel.add(SubmitBtn);

        add(SubmitWrapperPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String actionCmd = e.getActionCommand();

        if (e.getSource() == SubmitBtn)
        {
            mailAddress = mailInput.getText();
            if (mailAddress.equals("aaaa"))
            {
                SubmitWrapperPanel.setBackground(Color.BLUE);
            }
            else
            {
                mailWrapperPanel.add(new JLabel("invalid"), BorderLayout.SOUTH);
            }
        }
    }

}