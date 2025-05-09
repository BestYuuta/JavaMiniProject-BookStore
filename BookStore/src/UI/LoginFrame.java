package UI;

import BLL.AccountBLL;
import Config.CustomDialog;
import DTO.AccountDTO;
import DTO.LoginFormDTO;
import DTO.ResponseDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnSubmit, btnRegister;

    public LoginFrame() {
        setTitle("Login");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        btnSubmit.addActionListener(e -> handleLogin());
        btnRegister.addActionListener(e -> {
            dispose();
            new RegisterForm();
        });
    }

    private void handleLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        LoginFormDTO loginFormDTO = new LoginFormDTO(username, password);

        ResponseDTO response = AccountBLL.authenticateUser(loginFormDTO);

        if (response.getSuccess()) {
            CustomDialog.show(true, response.getMessage());
            AccountDTO accountDTO = (AccountDTO) response.getData();
//            if ("Admin".equalsIgnoreCase(accountDTO.getRole())) {
//                new AdminFrame();
//            } else if ("User".equalsIgnoreCase(accountDTO.getRole())) {
//                new UserFrame();
//            } else {
//                JOptionPane.showMessageDialog(
//                        this,
//                        "Unknown role: " + accountDTO.getRole(),
//                        "Error",
//                        JOptionPane.ERROR_MESSAGE
//                );
//            }

        } else {
            CustomDialog.show(false,"Error: " + response.getMessage());
        }
    }
}
