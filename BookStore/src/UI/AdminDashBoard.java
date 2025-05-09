import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookDetailForm extends JFrame {
    private JTextField titleField;
    private JTextField authorField;
    private JTextField priceField;
    private JTextArea descriptionArea;
    private JButton saveButton;

    public BookDetailForm() {
        setTitle("Book Detail Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Tạo panel chính
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Các thành phần
        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);

        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField(20);

        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField(20);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea(4, 20);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);

        saveButton = new JButton("Save");

        // Thêm các thành phần vào panel
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(titleLabel, gbc);
        gbc.gridx = 1;
        panel.add(titleField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(authorLabel, gbc);
        gbc.gridx = 1;
        panel.add(authorField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(priceLabel, gbc);
        gbc.gridx = 1;
        panel.add(priceField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(descriptionLabel, gbc);
        gbc.gridx = 1;
        panel.add(scrollPane, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        panel.add(saveButton, gbc);

        // Xử lý sự kiện khi nhấn nút "Save"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                String price = priceField.getText();
                String description = descriptionArea.getText();

                JOptionPane.showMessageDialog(BookDetailForm.this,
                        "Book Saved:\nTitle: " + title +
                                "\nAuthor: " + author +
                                "\nPrice: " + price +
                                "\nDescription: " + description,
                        "Book Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Thêm panel vào frame
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BookDetailForm();
    }
}
