package com.example.entity;

public class Book {
    private int id;
    private String title;
    private String description;
    private double price;
    private String author;
    private String publisher;
    private int quantity;

    public Book() {}

    public Book(int id, String title, String description, double price,
                String author, String publisher, int quantity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public int getQuantity() { return quantity; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', description='" + description +
               "', price=" + price + ", author='" + author + "', publisher='" + publisher +
               "', quantity=" + quantity + "}";
    }
}
