package com.example.service;

import com.example.entity.Book;
import com.example.entity.LoanRecord;
import com.example.repository.BookRepository;
import com.example.repository.BookRepositoryImpl;
import com.example.repository.LoanRecordRepository;
import com.example.repository.LoanRecordRepositoryImpl;
import com.example.repository.UserRepository;
import com.example.repository.UserRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class LoanRecordServiceImpl implements LoanRecordService {

    private LoanRecordRepository loanRepo = new LoanRecordRepositoryImpl();
    private BookRepository bookRepo = new BookRepositoryImpl();
    private UserRepository userRepo = new UserRepositoryImpl();
    
    public void newReturn(String Title) {
        try {
            Book book = bookRepo.searchBookByTitle(Title);

            if (book == null) {
                System.out.println("Book " + Title + " not found.");
                return;
            }
            for (LoanRecord l : loanRepo.list()) {
                if (l.getBookTitle().trim().equalsIgnoreCase(Title.trim())) {
                    l.setReturnDate(LocalDate.now());
                    loanRepo.newReturn(l);
                }
            }

            System.out.println("The book has been returned ");
        } catch (Exception e) {
            System.out.println("Error while returning book: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public List<LoanRecord> viewById(int idl) {
        try {
            if (loanRepo.viewById(idl) == null) {
                System.out.println("No book has been loaned here ");
            }
            return loanRepo.viewById(idl);
        } catch (Exception e) {
            System.out.println("Error while viewing records by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public void newRecord(String Title, int idl) {
        try {
            Book book = bookRepo.searchBookByTitle(Title);
            System.out.println("searching");
            if (book == null) {
                System.out.println("Book " + Title + " not found.");
                return;
            }
            if (userRepo.get(idl) == null) {
                System.out.println("User with id " + idl + " not found.");
            }

            int borrowedCount = 0;
            for (LoanRecord r : loanRepo.list()) {
                if (r.getBookTitle().trim().equalsIgnoreCase(Title) && r.getReturnDate() == null) {
                    borrowedCount++;
                }
            }

            if (borrowedCount >= book.getQuantity()) {
                System.out.println("No copies of '" + book.getTitle() + "' are available to loan.");
                return;
            }

            LocalDate borrowDate = LocalDate.now();
            LocalDate dueDate = borrowDate.plusDays(14);

            LoanRecord record = new LoanRecord(idl, book.getId(), book.getTitle(), borrowDate, dueDate, null);

            loanRepo.add(record);
            System.out.println("Loan recorded for '" + book.getTitle() + "'. Due: " + dueDate);
        } catch (Exception e) {
            System.out.println("Error while recording new loan: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<LoanRecord> allrecords() {
        try {
            System.out.println("List of all Loan records:");
            return loanRepo.list();
        } catch (Exception e) {
            System.out.println("Error while fetching all loan records: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
