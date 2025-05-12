package UI;

import BLL.UserBLL;
import DAL.BookDAL;
import DAL.RentalDAL;
import DTO.BookDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private int userId;

    public UserDashboard(int userId) {
        this.userId = userId;
        setTitle("Home");
        setContentPane(homePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,500);
        setLocationRelativeTo(null);
        setResizable(false);
        refreshData();
        setVisible(true);
        searchButton.addActionListener(e -> handleSearch());
        bookDetailButton.addActionListener(e -> handleBookDetail());
        rentedBookButton.addActionListener(e -> handleRentedBook());
        confirmButton.addActionListener(e -> handleConfirm());
        quitButton.addActionListener(e -> handleQuit());
    }
    public void handleSearch() {
        String keyword = txtSearch.getText().trim();
        if (keyword.isEmpty()) refreshData();

        BookDAL bookDAL = new BookDAL();
        List<BookDTO> books = new ArrayList<>();
        try {
            String selected = searchComboBox.getSelectedItem().toString();
            if (selected.equals("Theo tiêu đề")) {
                books = bookDAL.SearchBookByTitle(keyword);
            } else if (selected.equals("Theo tác giả")) {
                books = bookDAL.SearchBookByAuthor(keyword);
            }
            updateTable(books);
            confirmButton.setText("Xác nhận thuê");
            for (ActionListener al : confirmButton.getActionListeners()) {
                confirmButton.removeActionListener(al);
            }
            confirmButton.addActionListener(e -> handleConfirm());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void handleBookDetail() {
        int selectedRow = showTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một cuốn sách để xem chi tiết.");
            return;
        }

        int bookId = (int) showTable.getValueAt(selectedRow, 0);
        new UI.BookDetailForm(bookId, "user", userId);
    }
    public void handleRentedBook() {
        RentalDAL rentalDAL = new RentalDAL();
        try {
            List<BookDTO> books = rentalDAL.getRentedBooksByUser(userId);
            updateTable(books);

            confirmButton.setText("Trả sách");
            for (ActionListener al : confirmButton.getActionListeners()) {
                confirmButton.removeActionListener(al);
            }
            confirmButton.addActionListener(e -> {
                try {
                    handleReturnBook();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải sách đã thuê!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void handleConfirm() {
        int selectedRow = showTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách để thuê.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int bookId = (int) showTable.getValueAt(selectedRow, 0);
        RentalDAL rentalDAL = new RentalDAL();

        try {
            if (rentalDAL.hasUserRentedBook(userId, bookId)) {
                JOptionPane.showMessageDialog(this, "Bạn đã thuê sách này rồi.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi kiểm tra sách đã thuê!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success = rentalDAL.rentBook(userId, bookId);

        if (success) {
            JOptionPane.showMessageDialog(this, "Thuê sách thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        } else {
            JOptionPane.showMessageDialog(this, "Thuê sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void handleReturnBook() throws SQLException {
        int selectedRow = showTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách để trả.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int bookId = (int) showTable.getValueAt(selectedRow, 0);
        RentalDAL rentalDAL = new RentalDAL();
        boolean success = rentalDAL.returnBook(userId, bookId);

        if (success) {
            JOptionPane.showMessageDialog(this, "Trả sách thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            List<BookDTO> books = rentalDAL.getRentedBooksByUser(userId);
            updateTable(books);
        } else {
            JOptionPane.showMessageDialog(this, "Trả sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void handleQuit() {
        System.exit(0);
    }

    private void updateTable(java.util.List<BookDTO> books) {
        String[] columnNames = {"ID", "Title", "Author", "Stock", "Created At"};
        Object[][] data = new Object[books.size()][5];

        for (int i = 0; i < books.size(); i++) {
            BookDTO b = books.get(i);
            data[i][0] = b.getId();
            data[i][1] = b.getTitle();
            data[i][2] = b.getAuthor();
            data[i][3] = b.getStock();
            data[i][4] = b.getCreatedAt();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        showTable.setModel(model);
        showTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        showTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        showTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        showTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        showTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        showTable.getColumnModel().getColumn(4).setPreferredWidth(120);
    }
    private void refreshData() {
        try {
            java.util.List<BookDTO> books = new BookDAL().SearchBookByTitle("");
            updateTable(books);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
