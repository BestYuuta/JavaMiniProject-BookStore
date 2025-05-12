package DAL;

import Config.dbHelper;
import DTO.BookDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalDAL {

    public boolean rentBook(int userId, int bookId) {
        String checkStockSql = "SELECT stock FROM books WHERE id = ?";
        String rentSql = "INSERT INTO rentals (user_id, book_id, rent_date, status) VALUES (?, ?, NOW(), 'rented')";
        String updateStockSql = "UPDATE books SET stock = stock - 1 WHERE id = ?";

        try {
            ResultSet rs = dbHelper.executeQuery(checkStockSql, bookId);
            if (rs.next()) {
                int stock = rs.getInt("stock");
                if (stock <= 0) {
                    return false;
                }
            }

            int rentResult = dbHelper.executeUpdate(rentSql, userId, bookId);
            int stockResult = dbHelper.executeUpdate(updateStockSql, bookId);

            return rentResult > 0 && stockResult > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<BookDTO> getRentedBooksByUser(int userId) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        String sql = """
            SELECT b.id, b.title, b.author, b.stock, b.created_at
            FROM rentals r
            JOIN books b ON r.book_id = b.id
            WHERE r.user_id = ? AND r.status = 'rented'
        """;
        ResultSet rs = dbHelper.executeQuery(sql, userId);
        while (rs != null && rs.next()) {
            BookDTO book = new BookDTO();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setStock(rs.getInt("stock"));
            book.setCreatedAt(rs.getTimestamp("created_at"));
            list.add(book);
        }
        return list;
    }
    public boolean returnBook(int userId, int bookId) {
        String returnSql = "UPDATE rentals SET status = 'returned', return_date = NOW() WHERE user_id = ? AND book_id = ? AND status = 'rented'";
        String updateStockSql = "UPDATE books SET stock = stock + 1 WHERE id = ?";

        try {
            int returnResult = dbHelper.executeUpdate(returnSql, userId, bookId);
            int stockResult = dbHelper.executeUpdate(updateStockSql, bookId);
            return returnResult > 0 && stockResult > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean isBookRentedByUser(int userId, int bookId) {
        String sql = "SELECT * FROM rentals WHERE user_id = ? AND book_id = ? AND status = 'rented'";
        try (ResultSet rs = dbHelper.executeQuery(sql, userId, bookId)) {
            return rs != null && rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean hasUserRentedBook(int userId, int bookId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM rentals WHERE user_id = ? AND book_id = ? AND status = 'rented'";
        PreparedStatement ps = dbHelper.getInstance().prepareStatement(sql);
        ps.setInt(1, userId);
        ps.setInt(2, bookId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }
}
