package UI;

import javax.swing.*;

public class LoginFrame extends JFrame{
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton button1;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
