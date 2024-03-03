package com.example.examsystem.service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.examsystem.mapper.RecordingDataMapper;
import com.example.examsystem.model.LearningRecords;
import com.example.examsystem.model.RecordingData;
import com.example.examsystem.service.LearningRecordsSel;
import com.example.examsystem.util.SubmitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecordingDataServiceImpl extends ServiceImpl<RecordingDataMapper, RecordingData> implements com.example.examsystem.service.RecordingDataService {

    @Autowired
    private RecordingDataMapper recordingDataMapper;


    public List<RecordingData> learningRecords(LearningRecords learningRecords) {
        if (learningRecords.getPk()==0){
             return recordingDataMapper.selectList(null);
        }else {
            QueryWrapper<RecordingData> recordingDataQueryWrapper = new QueryWrapper<>();
            recordingDataQueryWrapper.eq("learningPeopleName",learningRecords.getLearningPeopleName());
            return recordingDataMapper.selectList(recordingDataQueryWrapper);
        }
    }

    public SubmitUtil downLoad() {

        return SubmitUtil.ok();
    }
}
