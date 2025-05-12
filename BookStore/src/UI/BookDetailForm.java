package UI;

import BLL.BookBLL;
import BLL.RentalBLL;
import DTO.BookDTO;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BookDetailForm extends JFrame{
    private BookBLL bookBLL;
    private int bookId;
    private String role;

    private JPanel BookDetailForm;
    private JPanel header;
    private JLabel lbtitle;
    private JPanel image;
    private JLabel lbimage;
    private JButton btnBack;
    private JButton btnBooking;
    private JPanel content;
    private JPanel content_left;
    private JPanel id_left;
    private JLabel lb_id_left;
    private JPanel title_left;
    private JLabel lb_title_left;
    private JPanel author_left;
    private JLabel lb_author_left;
    private JPanel stock_left;
    private JLabel lb_stock_left;
    private JPanel create_left;
    private JLabel lb_create_left;
    private JPanel content_right;
    private JPanel id_right;
    private JLabel lb_id_right;
    private JPanel title_right;
    private JLabel lb_title_right;
    private JPanel author_right;
    private JLabel lb_author_right;
    private JPanel stock_right;
    private JLabel lb_stock_right;
    private JPanel create_right;
    private JLabel lb_create_right;

    private int userId;
    private boolean isRented;
    private RentalBLL rentalBLL;

    public BookDetailForm(int bookId, String role, int userId) {
        this.bookId = bookId;
        this.role = role;
        this.userId = userId;
        this.bookBLL = new BookBLL();
        this.rentalBLL = new RentalBLL();

        setTitle("Book Detail");
        setContentPane(BookDetailForm);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        customizeUIBasedOnRole(role);
        btnBack.addActionListener(e -> handleBack());
        loadBookDetails();
        setVisible(true);
    }

    private void customizeUIBasedOnRole(String role){
        if ("admin".equalsIgnoreCase(this.role)){
            btnBooking.setText("Chỉnh sửa");
            btnBooking.addActionListener(e -> handleEdit());
        } else {
            isRented = rentalBLL.isBookRentedByUser(userId, bookId);
            btnBooking.setText(isRented ? "Trả sách" : "Thuê sách");
            btnBooking.addActionListener(e -> {
                if (isRented) {
                    handleReturnBook();
                } else {
                    handleBooking();
                }
            });
        }
    }

    private void loadBookDetails() {
        BookDTO book = bookBLL.getBookByID(bookId);
        if (book != null) {
            lb_id_right.setText(String.valueOf(book.getId()));
            lb_title_right.setText(book.getTitle());
            lb_author_right.setText(book.getAuthor());
            lb_stock_right.setText(String.valueOf(book.getStock()));
            lb_create_right.setText(String.valueOf(book.getCreatedAt()));
            try {
                String imagePath = book.getBookcover();
                if (!imagePath.startsWith("http://") && !imagePath.startsWith("https://") && !imagePath.startsWith("file://")) {
                    imagePath = "file:///" + imagePath.replace("\\", "/");
                }
                URL url = new URL(imagePath);
                ImageIcon icon = new ImageIcon(url);

                // Giới hạn kích thước ảnh
                Image image = icon.getImage();
                int maxWidth = 200;
                int maxHeight = 300;
                Image scaledImage = image.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
                lbimage.setIcon(new ImageIcon(scaledImage));

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleBack() {
        dispose();
    }

    private void handleBooking() {
        boolean success = rentalBLL.rentBook(userId, bookId);
        if (success) {
            JOptionPane.showMessageDialog(this, "Thuê sách thành công!");
            isRented = true;
            dispose();
            btnBooking.setText("Trả sách");
        } else {
            JOptionPane.showMessageDialog(this, "Thuê sách thất bại!");
        }
    }

    private void handleReturnBook() {
        boolean success = rentalBLL.returnBook(userId, bookId);
        if (success) {
            JOptionPane.showMessageDialog(this, "Trả sách thành công!");
            isRented = false;
            dispose();
            btnBooking.setText("Thuê sách");
        } else {
            JOptionPane.showMessageDialog(this, "Trả sách thất bại!");
        }
    }
    private void handleEdit() {
        BookDTO book = bookBLL.getBookByID(bookId);
        if (book != null) {
            new BookEditForm(book, () -> {
                this.dispose();
                loadBookDetails();
            });
        }
    }
    }
