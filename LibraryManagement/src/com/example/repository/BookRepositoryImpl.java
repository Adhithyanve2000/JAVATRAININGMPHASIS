package com.example.repository;

import com.example.entity.Book;
import java.util.*;

public class BookRepositoryImpl implements BookRepository {

    static List<Book> Books = new ArrayList<>();

    public void add(Book book) {
        try {
            Books.add(book);
        } catch (Exception e) {
            System.out.println("Error while adding book: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            for (int i = 0; i < Books.size(); i++) {
                if (Books.get(i).getId() == id) {
                    Books.remove(i);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while deleting book by ID: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteBookByName(String Title) {
        try {
            for (int i = 0; i < Books.size(); i++) {
                if (Books.get(i).getTitle().equals(Title)) {
                    Books.remove(i);
                    System.out.println("The book has been deleted");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while deleting book by name: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Book searchBookByTitle(String Title) {
        try {
            for (int i = 0; i < Books.size(); i++) {
                if (Books.get(i).getTitle().trim().equalsIgnoreCase(Title.trim())) {
                    System.out.println("Here is the book:");
                    return Books.get(i);
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error while searching book by title: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> list() {
        try {
            return Books;
        } catch (Exception e) {
            System.out.println("Error while listing books: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Book get(int id) {
        try {
            for (int i = 0; i < Books.size(); i++) {
                if (Books.get(i).getId() == id) {
                    System.out.println("Here is the book:");
                    return Books.get(i);
                }
            }
            System.out.println("There is no such book");
            return null;
        } catch (Exception e) {
            System.out.println("Error while getting book by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

	

