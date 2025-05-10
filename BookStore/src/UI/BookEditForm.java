package UI;

import BLL.BookBLL;
import DTO.BookDTO;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;

public class BookEditForm extends JFrame{
    private JPanel BookDetailForm;
    private JPanel header;
    private JLabel lbtitle;
    private JPanel image;
    private JLabel lbimage;
    private JPanel content;
    private JPanel content_left;
    private JPanel title_left;
    private JLabel lb_title_left;
    private JPanel author_left;
    private JLabel lb_author_left;
    private JPanel stock_left;
    private JLabel lb_stock_left;
    private JPanel content_right;
    private JPanel title_right;
    private JPanel author_right;
    private JPanel stock_right;
    private JButton btnBack;
    private JButton btnSubmit;
    private JTextField txtBookName;
    private JTextField txtAuthor;
    private JTextField txtStock;
    private JButton btnChooseImage;
    private JTextField txtBookCover;

    private BookDTO book; // null nếu là thêm mới
    private BookBLL bookBLL;

    public BookEditForm(BookDTO bookToEdit, Runnable onSuccessCallback) {
        this.book = bookToEdit;
        this.bookBLL = new BookBLL();

        setTitle(book == null ? "Thêm sách mới" : "Chỉnh sửa sách");
        setContentPane(BookDetailForm);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Nếu là sửa thì điền dữ liệu cũ vào
        if (book != null) {
            txtBookName.setText(book.getTitle());
            txtAuthor.setText(book.getAuthor());
            txtStock.setText(String.valueOf(book.getStock()));
            showImagePreview(book.getBookcover());
        }

        btnChooseImage.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn ảnh bìa");
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Hình ảnh", "jpg", "jpeg", "png", "gif"));

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                java.io.File selectedFile = fileChooser.getSelectedFile();
                String imagePath = selectedFile.getAbsolutePath();
                txtBookCover.setText(imagePath); // Lưu đường dẫn ảnh vào TextField
                showImagePreview("file:///" + imagePath.replace("\\", "/")); // Hiển thị ảnh đã chọn
            }
        });

        btnSubmit.addActionListener(e -> {
            String title = txtBookName.getText().trim();
            String author = txtAuthor.getText().trim();
            int stock;

            try {
                stock = Integer.parseInt(txtStock.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String bookCover = txtBookCover.getText().trim();  // Lấy đường dẫn ảnh từ textbox

            if (title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (book == null) {
                if (bookCover.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh bìa cho sách mới!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                BookDTO newBook = new BookDTO(0, title, author, stock, new Timestamp(System.currentTimeMillis()), bookCover);
                bookBLL.addBook(newBook);
                JOptionPane.showMessageDialog(this, "Thêm sách thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            } else {
                book.setTitle(title);
                book.setAuthor(author);
                book.setStock(stock);
                if (!bookCover.isEmpty()) {
                    book.setBookcover(bookCover);
                }

                bookBLL.updateBook(book);
                JOptionPane.showMessageDialog(this, "Cập nhật sách thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }

            onSuccessCallback.run();
            dispose();
        });

        btnBack.addActionListener(e -> dispose());

        setVisible(true);
    }
    private void showImagePreview(String imagePath) {
        try {
            if (!imagePath.startsWith("http://") && !imagePath.startsWith("https://") && !imagePath.startsWith("file://")) {
                imagePath = "file:///" + imagePath.replace("\\", "/");
            }

            URL url = new URL(imagePath);
            ImageIcon icon = new ImageIcon(url);

            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(lbimage.getWidth(), lbimage.getHeight(), Image.SCALE_SMOOTH);
            lbimage.setIcon(new ImageIcon(scaledImage));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
