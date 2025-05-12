package UI;

import DTO.RegisterFormDTO;

import javax.swing.*;

public class RegisterForm extends JFrame{
    private JPanel containPane;
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnSubmit;
    private JButton btnLogin;
    private JTextField txtName;

    public RegisterForm(){
        setTitle("Register");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        btnLogin.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });
        btnSubmit.addActionListener(e -> handleRegister());
    }

    private void handleRegister() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        String name = txtName.getText().trim();

        if (username.isEmpty() || password.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy điền hết thông tin!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Username không thể có khoảng trống!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() <= 5) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải có ít nhất 6 ký tự!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        RegisterFormDTO registerFormDTO = new RegisterFormDTO(username, password, name);
        var response = BLL.AccountBLL.registerUser(registerFormDTO);

        if (response.getSuccess()) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new LoginFrame();
        } else {
            JOptionPane.showMessageDialog(this, "Register failed: " + response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
