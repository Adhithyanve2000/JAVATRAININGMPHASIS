package com.example.repository;

import com.example.entity.LoanRecord;
import java.util.ArrayList;
import java.util.List;

public class LoanRecordRepositoryImpl implements LoanRecordRepository {

    private static List<LoanRecord> loanRecords = new ArrayList<>();

    public void add(LoanRecord record) {
        try {
            loanRecords.add(record);
            System.out.println("The book has been loaned");
        } catch (Exception e) {
            System.out.println("Error while adding loan record: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<LoanRecord> viewById(int idl) {
        try {
            List<LoanRecord> loanRecords1 = new ArrayList<>();
            System.out.println("The book has been loaned");
            for (int i = 0; i < loanRecords.size(); i++) {
                if (loanRecords.get(i).getUserId() == idl) {
                    loanRecords1.add(loanRecords.get(i));
                }
            }
            return loanRecords1;
        } catch (Exception e) {
            System.out.println("Error while viewing loan records by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<LoanRecord> list() {
        try {
            return loanRecords;
        } catch (Exception e) {
            System.out.println("Error while listing loan records: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void newReturn(LoanRecord l) {
        try {
            for (int i = 0; i < loanRecords.size(); i++) {
                if (loanRecords.get(i).getBookTitle().trim()
                        .equalsIgnoreCase(l.getBookTitle().trim())) {
                    loanRecords.set(i, l);
                }
            }
            System.out.print("The book has been returned");
        } catch (Exception e) {
            System.out.println("Error while returning loan record: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

