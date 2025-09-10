package com.example.service;

import com.example.entity.LoanRecord;
import java.util.List;

public interface LoanRecordService {
	void newRecord(String Title,int idl);  
    List<LoanRecord> allrecords();
     void newReturn(String Title);
     List<LoanRecord> viewById(int id1);
}
