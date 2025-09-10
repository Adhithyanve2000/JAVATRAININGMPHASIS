package com.example.repository;

import java.util.*;
import com.example.entity.Book;

public interface BookRepository
{
	    void add(Book book);
	     Book get(int id);
	    void delete(int id);
	    List<Book> list();
	    
	    Book searchBookByTitle(String Title);
	    void deleteBookByName(String Title);
	}

      

