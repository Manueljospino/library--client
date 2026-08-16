package com.mycompany.library;

public class Book extends Item{
    private String author;
    private boolean available;

    public Book(String code, String title, int publicationYear, String author, boolean available) {
        super(code, title, publicationYear);
        this.author = author;
        this.available = available;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
