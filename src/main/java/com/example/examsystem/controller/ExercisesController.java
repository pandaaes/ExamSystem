package com.example.examsystem.controller;

import com.example.examsystem.mapper.RecordingDataMapper;
import com.example.examsystem.model.LearingExercises;
import com.example.examsystem.model.LearningRecords;
import com.example.examsystem.model.QuestionbankData;
import com.example.examsystem.model.RecordingData;
import com.example.examsystem.service.LearningRecordsSel;
import com.example.examsystem.service.ServiceImpl.*;
import com.example.examsystem.util.ChangeUtil;
import com.example.examsystem.util.DelUtil;
import com.example.examsystem.util.SubmitUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/exercises")
public class ExercisesController {

    @Autowired
    private UserDataServiceImpl userDataService;

    @Autowired
    private AdministratorDataServiceImpl administratorDataService;

    @Autowired
    private QuestionbankDataServiceImpl questionbankDataService;

    @Autowired
    private RecordingDataServiceImpl recordingDataService;

    @Autowired
    private RecordingDataMapper recordingDataMapper;

    @Resource
    private AuthServiceImpl authService;


    /**
     * 查询
     */
    @PostMapping("/GetPutExercisesDatas")
    public List<QuestionbankData> getExercisesDatas(@RequestBody String chapterid){
        return questionbankDataService.getExercisesDatas(chapterid);
    }

    /**
     * 修改
     */
    @PutMapping("/GetPutExercisesDatas")
    public ChangeUtil putExercisesDatas(@RequestBody QuestionbankData questionbankData){
        return questionbankDataService.putExercisesDatas(questionbankData);
    }

    /**
     * 删除
     */
    @PutMapping("/ActionsExercisesDatas")
    public DelUtil actionsExercisesDatas(@RequestBody int id){
        return questionbankDataService.del(id);
    }

    /**
     * 用户考试提交
     */
    @PostMapping("/learingExercises")
    public SubmitUtil learingExercises(@RequestBody LearingExercises learingExercises){
        return questionbankDataService.learingExercises(learingExercises);
    }

    /**
     * 获取学习记录
     */
    @PostMapping("/LearningRecords")
    public List<RecordingData> learningRecords(@RequestBody LearningRecords learningRecords){
        return recordingDataService.learningRecords(learningRecords);
    }

    /**
     * 考试记录下载
     */
    @RequestMapping("/downLoad")
    public void downLoad(HttpServletResponse response) throws IOException {
        List<RecordingData> recordingData = authService.getAllCompany();
//下载
        HSSFWorkbook wb = authService.downloadExcel(recordingData);
        OutputStream output = response.getOutputStream();
// 文件名中文形式
        String fileName = "成绩单"+".xls";//
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Content-disposition", "attachment;filename="+fileName+";"+"filename*=utf-8''"+fileName);
// 文件名日期形式
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//        response.addHeader("Content-Disposition", "attachment;filename=" +
//        + new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date()) + ".xls");
// 文件名英文形式
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
//        response.setContentType("application/msexcel");

//        response.setContentType("application/vnd.ms-excel");
        wb.write(output);
        output.close();
    }

}
