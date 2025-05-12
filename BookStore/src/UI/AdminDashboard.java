package UI;

import Config.dbHelper;
import DAL.BookDAL;
import DTO.BookDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDashboard extends JFrame {
    private JTable adminShowTable;
    private JTextField txtAdminSearch;
    private JButton adminSearchButton;
    private JButton bookAdminDetailButton;
    private JComboBox searchAdminComboBox;
    private JButton addAdminButton;
    private JButton deleteAdminButton;
    private JButton editAdminButton;
    private JButton quitAdminButton;
    private JPanel homeAdminPanel;
    private JPanel outlineAdminPanel;
    public AdminDashboard() {
        setTitle("Home");
        setContentPane(homeAdminPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        refreshData();
        setVisible(true);
        adminShowTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        adminSearchButton.addActionListener(e -> handleSearch());
        bookAdminDetailButton.addActionListener(e -> handleBookDetail());
        addAdminButton.addActionListener(e -> handleAdd());
        deleteAdminButton.addActionListener(e -> handleDelete());
        editAdminButton.addActionListener(e -> handleEdit());
        quitAdminButton.addActionListener(e -> handleQuit());
    }
    public void handleSearch() {
        String keyword = txtAdminSearch.getText().trim();
        if (keyword.isEmpty()) refreshData();

        BookDAL bookDAL = new BookDAL();
        List<BookDTO> books = new ArrayList<>();
        try {
            String selected = searchAdminComboBox.getSelectedItem().toString();
            if (selected.equals("Theo tiêu đề")) {
                books = bookDAL.SearchBookByTitle(keyword);
            } else if (selected.equals("Theo tác giả")) {
                books = bookDAL.SearchBookByAuthor(keyword);
            }
            updateTable(books);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void handleBookDetail() {
        int selectedRow = adminShowTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một cuốn sách để xem chi tiết.");
            return;
        }

        int bookId = (int) adminShowTable.getValueAt(selectedRow, 0);
        new UI.BookDetailForm(bookId, "admin", -1);
    }
    public void handleAdd() {
        new BookEditForm(null, this::refreshData);
    }
    public void handleDelete() {
        int selectedRow = adminShowTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một cuốn sách để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa cuốn sách này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        int bookId = (int) adminShowTable.getValueAt(selectedRow, 0);

        BookDAL bookDAL = new BookDAL();
        try {
            bookDAL.deleteBook(bookId);
            ((DefaultTableModel) adminShowTable.getModel()).removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Đã xóa sách thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa sách!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void handleEdit() {
        int selectedRow = adminShowTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một cuốn sách để chỉnh sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int bookId = (int) adminShowTable.getValueAt(selectedRow, 0);
        BookDAL bookDAL = new BookDAL();

        try {
            BookDTO book = bookDAL.getBookByID(bookId);
            if (book != null) {
                new BookEditForm(book, this::refreshData);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sách!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu sách!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void handleQuit() {
        System.exit(0);
    }
    private void updateTable(List<BookDTO> books) {
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
        adminShowTable.setModel(model);
        adminShowTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        adminShowTable.getColumnModel().getColumn(0).setPreferredWidth(30);  // ID
        adminShowTable.getColumnModel().getColumn(1).setPreferredWidth(150); // Title
        adminShowTable.getColumnModel().getColumn(2).setPreferredWidth(100); // Author
        adminShowTable.getColumnModel().getColumn(3).setPreferredWidth(50);  // Stock
        adminShowTable.getColumnModel().getColumn(4).setPreferredWidth(120); // Created At
    }
    private void refreshData() {
        try {
            List<BookDTO> books = new BookDAL().SearchBookByTitle(""); // Lấy tất cả sách
            updateTable(books);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
