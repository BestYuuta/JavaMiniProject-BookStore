package UI;

import BLL.UserBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UserDashboard extends JFrame {
    private JTable showTable;
    private JTextField txtSearch;
    private JComboBox searchComboBox;
    private JButton searchButton;
    private JButton bookDetailButton;
    private JButton rentedBookButton;
    private JButton confirmButton;
    private JButton quitButton;
    private JPanel homePanel;
    private JPanel outlinePanel;
    public UserDashboard() {
        setTitle("Home");
        setContentPane(homePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        searchButton.addActionListener(e -> handleSearch());
        bookDetailButton.addActionListener(e -> handleBookDetail());
        rentedBookButton.addActionListener(e -> handleRentedBook());
        confirmButton.addActionListener(e -> handleConfirm());
        quitButton.addActionListener(e -> handleQuit());
    }
    public void handleSearch() {
        UserBLL userBLL = new UserBLL();
        if (searchComboBox.getSelectedItem().equals("Theo tiêu đề")) {
//            showTable.addColumn();
        }
        if (searchComboBox.getSelectedItem().equals("Theo tác giả")) {

        }
        if (txtSearch.getText().isEmpty())
            return;
    }
    public void handleBookDetail() {
        //BookDetailForm f = new BookDetailForm();
    }
    public void handleRentedBook() {

    }
    public void handleConfirm() {

    }
    public void handleQuit() {
        //System.exit(0);
    }
}
