package DTO;

public class RentalDTO {
    private int id;
    private int bookId;
    private int userId;
    private String rentalDate;
    private String returnDate;
    private String status;

    public RentalDTO(int id, int bookId, int userId, String rentalDate, String returnDate, String status) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRentalDate() {
        return rentalDate;
    }
    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
