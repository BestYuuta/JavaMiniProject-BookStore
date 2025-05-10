package UI;

import BLL.BookBLL;
import DTO.BookDTO;
import DAL.BookDAL;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;

public class BookDetailForm extends JFrame{
    private BookBLL bookBLL;
    private int bookId;

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

    public BookDetailForm(int bookId) {
        this.bookId = bookId;
        bookBLL = new BookBLL();

        setTitle("Book Detail");
        setContentPane(BookDetailForm);
        setSize(800, 600);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        loadBookDetails();

        btnBack.addActionListener(e -> handleBack());
        btnBooking.addActionListener(e -> handleBooking());

        pack();
        setResizable(true);
        setVisible(true);
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
                URL url = new URL(book.getImglink());
                ImageIcon icon = new ImageIcon(url);
                lbimage.setIcon(icon);
            } catch ( MalformedURLException e) {
                e.printStackTrace();
            }

        }
    }

    private void handleBack() {
        this.dispose();
    }

    private void handleBooking() {
        BookDTO book = bookBLL.getBookByID(bookId);
//        if (book != null && book.getStock() > 0) {
//            JOptionPane.showMessageDialog(this, "Đã đặt sách '" + book.getTitle() + "' thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(this, "Sách đã hết hoặc không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        }
    }
    }
