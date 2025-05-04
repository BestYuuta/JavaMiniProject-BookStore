package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Đăng nhập hệ thống quản lý nhà sách");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // canh giữa màn hình

        // Font đẹp hơn
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 16);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 16);

        // Panel chứa form
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panelForm.setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelForm.add(new JLabel("Tên đăng nhập:"), gbc);

        // TextField Username
        gbc.gridx = 1;
        txtUsername = new JTextField(20);
        txtUsername.setFont(inputFont);
        panelForm.add(txtUsername, gbc);

        // Label Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelForm.add(new JLabel("Mật khẩu:"), gbc);

        // TextField Password
        gbc.gridx = 1;
        txtPassword = new JPasswordField(20);
        txtPassword.setFont(inputFont);
        panelForm.add(txtPassword, gbc);

        // Button Login
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(labelFont);
        btnLogin.setBackground(new Color(66, 133, 244));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new Dimension(140, 40));
        btnLogin.addActionListener(this::handleLogin);
        panelForm.add(btnLogin, gbc);

        // Gắn form vào frame
        add(panelForm);
    }

    private void handleLogin(ActionEvent e) {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        // TODO: Xác thực từ DB
        if (username.equals("admin") && password.equals("123")) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
            new BookManage().setVisible(true); // Giả sử đây là frame chính
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
