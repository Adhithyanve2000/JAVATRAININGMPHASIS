package com.example.entity;

import java.time.LocalDate;

public class LoanRecord {
    private int bookId;
    private String bookTitle;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private int userId;
    
    public LoanRecord() {}

    public LoanRecord(int userId,int bookId, String bookTitle, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate) {
        this.userId=userId;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public int getBookId() { return bookId; }
    public int getUserId() { return userId; }
    public String getBookTitle() { return bookTitle; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setBookId(int bookId) { this.bookId = bookId; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    @Override
    public String toString() {
        return "LoanRecord{bookId=" + bookId + ", bookTitle='" + bookTitle + "', borrowDate=" + borrowDate +
               ", dueDate=" + dueDate + ", returnDate=" + returnDate +", userId="+ userId +"}";
    }
}

