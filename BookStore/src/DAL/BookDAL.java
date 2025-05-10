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
                rs.getString("img")
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
}
