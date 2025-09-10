package com.example.repository;

import com.example.entity.LoanRecord;
import java.util.List;

public interface LoanRecordRepository {
    void add(LoanRecord record);
    List<LoanRecord> viewById(int idl);
    List<LoanRecord> list();
    void newReturn(LoanRecord l);
   
}
