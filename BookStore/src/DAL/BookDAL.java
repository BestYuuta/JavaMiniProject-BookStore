package DAL;

import Config.dbHelper;
import DTO.BookDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAL {
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
}