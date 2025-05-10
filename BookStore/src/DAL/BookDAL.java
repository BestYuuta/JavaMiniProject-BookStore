package DAL;

import Config.dbHelper;
import DTO.BookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAL {
    public List<BookDTO> SearchBookByTitle(String search) throws SQLException {
        String query = "SELECT * FROM books WHERE title LIKE ?";
        search = "%" + search + "%";
        ResultSet rs = dbHelper.executeQuery(query, search);
        List<BookDTO> list = new ArrayList<>();
        while (rs.next()) {
            BookDTO temp = new BookDTO(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("stock"),
                rs.getTimestamp("created_at"),
                rs.getString("bookcover")
            );
            list.add(temp);
        }
        return list;
    }

    public List<BookDTO> SearchBookByAuthor(String author) throws SQLException {
        String query = "SELECT * FROM books WHERE author LIKE ?";
        author = "%" + author + "%";
        ResultSet rs = dbHelper.executeQuery(query, author);
        List<BookDTO> list = new ArrayList<>();
        while (rs.next()) {
            BookDTO temp = new BookDTO(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("stock"),
                    rs.getTimestamp("created_at"),
                    rs.getString("bookcover")
            );
            list.add(temp);
        }
        return list;
    }

    public BookDTO getBookByID(int id) throws SQLException {
        ResultSet rs = dbHelper.executeQuery("SELECT * FROM books WHERE id = ?", Integer.toString(id));
        if (rs.next()) {
            return new BookDTO(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("stock"),
                    rs.getTimestamp("created_at"),
                    rs.getString("bookcover")
            );
        }
        return null;
    }

    public void insertBook(BookDTO book) {
        String sql = "INSERT INTO books(title, author, stock, created_at, bookcover) VALUES (?, ?, ?, ?, ?)";
        dbHelper.executeUpdate(sql, book.getTitle(), book.getAuthor(), book.getStock(), book.getCreatedAt(), book.getBookcover());
    }

    public void updateBook(BookDTO book) {
        String sql = "UPDATE books SET title=?, author=?, stock=?, bookcover=? WHERE id=?";
        dbHelper.executeUpdate(sql, book.getTitle(), book.getAuthor(), book.getStock(), book.getBookcover(), book.getId());
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id=?";
        dbHelper.executeUpdate(sql, id);
    }
}
