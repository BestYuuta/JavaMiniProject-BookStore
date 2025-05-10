package BLL;

import DAL.BookDAL;
import DTO.BookDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookBLL {
    private BookDAL bookDAL;

    public BookBLL() {
        bookDAL = new BookDAL();
    }

    public BookDTO getBookByID(int bookId) {

            try {
                return bookDAL.getBookByID(bookId);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
