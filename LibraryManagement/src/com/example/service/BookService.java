package com.example.service;

import java.util.List;

import com.example.entity.Book;

public interface BookService {
	void addBook(int id, String title, String description, double price,
            String author, String publisher, int quantity);
    void delete(int id);
    List<Book> list();
    
    Book searchBookByTitle(String Title);
    Book get(int id);
    void deleteBookByName(String Title);
}
