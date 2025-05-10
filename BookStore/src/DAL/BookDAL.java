package DAL;

import Config.dbHelper;
import DTO.BookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAL {
    public List<BookDTO> SearchBookByTitle(String search) throws SQLException {
        String query = "select * from books where title like ?";
        search = "%" + search + "%";
        ResultSet rs = dbHelper.executeQuery(query, search);
        List<BookDTO> list = new ArrayList<BookDTO>();
        while (rs.next()) {
            BookDTO temp = new BookDTO(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("stock"),
                    rs.getTimestamp("created_at")
            );
            list.add(temp);
        }
        return list;
    }
}
