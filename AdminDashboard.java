package UI;

import javax.swing.*;

public class AdminDashboard extends JFrame {
    private JTable adminShowTable;
    private JTextField txtAdminSearch;
    private JButton adminSearchButton;
    private JButton bookAdminDetailButton;
    private JComboBox searchAdminComboBox;
    private JButton addAdminButton;
    private JButton deleteAdminButton;
    private JButton editAdminButton;
    private JButton adminRentedBookButton;
    private JButton quitAdminButton;
    private JPanel homeAdminPanel;
    private JPanel outlineAdminPanel;
    public AdminDashboard() {
        setTitle("Home");
        setContentPane(homeAdminPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        adminSearchButton.addActionListener(e -> handleSearch());
        bookAdminDetailButton.addActionListener(e -> handleBookDetail());
        adminRentedBookButton.addActionListener(e -> handleRentedBook());
        addAdminButton.addActionListener(e -> handleAdd());
        deleteAdminButton.addActionListener(e -> handleDelete());
        editAdminButton.addActionListener(e -> handleEdit());
        quitAdminButton.addActionListener(e -> handleQuit());
    }
    public void handleSearch() {
        if (searchAdminComboBox.getSelectedItem().equals("Theo tiêu đề")) {
            //dbHelper
        }
        if (searchAdminComboBox.getSelectedItem().equals("Theo tác giả")) {

        }
        if (txtAdminSearch.getText().isEmpty())
            return;
    }
    public void handleBookDetail() {
        //BookDetailForm f = new BookDetailForm();
    }
    public void handleRentedBook() {

    }
    public void handleAdd() {

    }
    public void handleDelete() {

    }
    public void handleEdit() {

    }
    public void handleQuit() {
        //System.exit(0);
    }
}
