package BLL;

import DAL.BookDAL;
import DTO.BookDTO;
import DAL.UserDAL;

import java.util.ArrayList;
import java.util.List;

public class UserBLL {
    public List<BookDTO> GetSearchedBook(String search) {
        try {
            BookDAL bookDAL = new BookDAL();
            return bookDAL.SearchBookByTitle(search);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
