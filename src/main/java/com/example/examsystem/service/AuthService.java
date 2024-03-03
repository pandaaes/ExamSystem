package com.example.examsystem.service;

import com.example.examsystem.model.RecordingData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

public interface AuthService {
    HSSFWorkbook downloadExcel(List<RecordingData> list);
    List<RecordingData> getAllCompany();

}
