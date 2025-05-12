package BLL;

import DAL.RentalDAL;

public class RentalBLL {
    private RentalDAL rentalDAL;

    public RentalBLL() {
        rentalDAL = new RentalDAL();
    }

    public boolean rentBook(int userId, int bookId) {
        return rentalDAL.rentBook(userId, bookId);
    }

    public boolean returnBook(int userId, int bookId) {
        return rentalDAL.returnBook(userId, bookId);
    }

    public boolean isBookRentedByUser(int userId, int bookId) {
        return rentalDAL.isBookRentedByUser(userId, bookId);
    }
}
