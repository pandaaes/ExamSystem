package com.example.examsystem.service.ServiceImpl;

import com.example.examsystem.mapper.RecordingDataMapper;
import com.example.examsystem.model.RecordingData;
import com.example.examsystem.service.AuthService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RecordingDataMapper recordingDataMapper;

    @Override
    public HSSFWorkbook downloadExcel(List<RecordingData> list) {
        String[] excelHeader = { "id", "考试时间","姓名","章节","成绩"};
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("关系表");
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for (int i = 0; i < excelHeader.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
            //设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
            sheet.setColumnWidth(cell.getColumnIndex(), 100 * 50);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            RecordingData recordingData = list.get(i);
            row.createCell(0).setCellValue(recordingData.getId());
            row.createCell(1).setCellValue(recordingData.getTimes().format(formatter));
            row.createCell(2).setCellValue(recordingData.getLearningPeopleName());
            row.createCell(3).setCellValue(recordingData.getChapter());
            row.createCell(4).setCellValue(recordingData.getFraction());
        }
        return wb;

    }

    @Override
    public List<RecordingData> getAllCompany() {
        return  recordingDataMapper.selectList(null);
    }
}
