package BLL;

import DAL.BookDAL;
import DTO.BookDTO;

import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.List;

public class BookBLL {
    private final BookDAL bookDAL;

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

    public boolean addBook(BookDTO book) {
        try {
            if (book.getCreatedAt() == null) {
                book.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            }
            bookDAL.insertBook(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBook(BookDTO book) {
        try {
            bookDAL.updateBook(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(int bookId) {
        try {
            bookDAL.deleteBook(bookId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<BookDTO> searchByTitle(String title) {
        try {
            return bookDAL.SearchBookByTitle(title);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<BookDTO> searchByAuthor(String author) {
        try {
            return bookDAL.SearchBookByAuthor(author);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
