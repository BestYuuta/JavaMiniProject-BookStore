package DTO;

import java.sql.Timestamp;

public class BookDTO {
    private int id;
    private String title;
    private String author;
    private int stock;
    private Timestamp createdAt;
    private String imglink;

    public BookDTO(int id, String title, String author, int stock, Timestamp createdAt, String imglink) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.createdAt = createdAt;
        this.imglink=imglink;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getImglink(){return imglink;}
    public void setImglink(String imglink){this.imglink=imglink; }
}
