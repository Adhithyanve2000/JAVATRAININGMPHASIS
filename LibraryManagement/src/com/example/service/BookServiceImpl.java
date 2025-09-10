package com.example.service;

import java.util.*;
import com.example.repository.BookRepositoryImpl;
import com.example.repository.BookRepository;
import com.example.entity.Book;

public class BookServiceImpl implements BookService {

    BookRepository bri = new BookRepositoryImpl();

    public void addBook(int id, String title, String description, double price, String author, String publisher, int quantity) {
        try {
            Book bk = new Book();
            bk.setId(id);
            bk.setTitle(title);
            bk.setDescription(description);
            bk.setPrice(price);
            bk.setAuthor(author);
            bk.setPublisher(publisher);
            bk.setQuantity(quantity);
            bri.add(bk);
            System.out.println("The book has been added");
        } catch (Exception e) {
            System.err.println("Error adding the book: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            bri.delete(id);
            System.out.println("The book has been deleted");
        } catch (Exception e) {
            System.err.println("Error deleting the book: " + e.getMessage());
        }
    }

    public List<Book> list() {
        try {
            return bri.list();
        } catch (Exception e) {
            System.err.println("Error fetching book list: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Book get(int id) {
        try {
            return bri.get(id);
        } catch (Exception e) {
            System.err.println("Error fetching the book: " + e.getMessage());
            return null;
        }
    }

    public Book searchBookByTitle(String title) {
        try {
            return bri.searchBookByTitle(title);
        } catch (Exception e) {
            System.err.println("Error searching the book by title: " + e.getMessage());
            return null;
        }
    }

    public void deleteBookByName(String title) {
        try {
            bri.deleteBookByName(title);
            System.out.println("The book has been deleted");
        } catch (Exception e) {
            System.err.println("Error deleting the book by name: " + e.getMessage());
        }
    }
}
