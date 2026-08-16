package com.mycompany.library;
import java.time.LocalDate;

public class Loan {
    private String id;
    private Customer customer;
    private Book book;
    private LocalDate date;
    private String status;
    public Loan(String id, Customer customer, Book book, LocalDate date, String status) {
        this.id = id;
        this.customer = customer;
        this.book = book;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
