package com.example.examsystem.service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.examsystem.mapper.QuestionbankDataMapper;
import com.example.examsystem.mapper.RecordingDataMapper;
import com.example.examsystem.mapper.UserDataMapper;
import com.example.examsystem.model.LearingExercises;
import com.example.examsystem.model.QuestionbankData;
import com.example.examsystem.model.RecordingData;
import com.example.examsystem.model.UserData;
import com.example.examsystem.service.QuestionbankDataService;
import com.example.examsystem.util.ChangeUtil;
import com.example.examsystem.util.DelUtil;
import com.example.examsystem.util.SubmitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionbankDataServiceImpl extends ServiceImpl<QuestionbankDataMapper, QuestionbankData> implements QuestionbankDataService {

    @Autowired
    private QuestionbankDataMapper questionbankDataMapper;

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private RecordingDataMapper recordingDataMapper;

    public List<QuestionbankData> getExercisesDatas(String chapterid) {
        QueryWrapper<QuestionbankData> questionbankDataQueryWrapper = new QueryWrapper<>();
        questionbankDataQueryWrapper.eq("chapter",chapterid);
        List<QuestionbankData> questionbankData = questionbankDataMapper.selectList(questionbankDataQueryWrapper);
        return questionbankData;
    }

    public ChangeUtil putExercisesDatas(QuestionbankData questionbankData) {
        try {
            UpdateWrapper<QuestionbankData> questionbankDataUpdateWrapper = Wrappers.update();
            if (questionbankData.getChapter() != null){
                questionbankDataUpdateWrapper.set("chapter",questionbankData.getChapter());
            }
            if (questionbankData.getTitle() != null){
                questionbankDataUpdateWrapper.set("title",questionbankData.getTitle());
            }
            if (questionbankData.getOpA() != null){
                questionbankDataUpdateWrapper.set("opA",questionbankData.getOpA());
            }
            if (questionbankData.getOpB() != null){
                questionbankDataUpdateWrapper.set("opB",questionbankData.getOpB());
            }
            if (questionbankData.getOpC() != null){
                questionbankDataUpdateWrapper.set("opC",questionbankData.getOpC());
            }
            if (questionbankData.getOpD() != null){
                questionbankDataUpdateWrapper.set("opD",questionbankData.getOpD());
            }
            if (questionbankData.getCorrectAnswer() != null){
                questionbankDataUpdateWrapper.set("correct_answer",questionbankData.getCorrectAnswer());
            }
            questionbankDataUpdateWrapper.eq("id",questionbankData.getId());
            questionbankDataMapper.update(null,questionbankDataUpdateWrapper);
            return ChangeUtil.ok();
        }catch (Exception e){
            return ChangeUtil.fail();
        }
    }

    public DelUtil del(int i) {
        try {
            questionbankDataMapper.deleteById(i);
            return DelUtil.ok();
        }catch (Exception e){
            return DelUtil.fail();
        }
    }

    public SubmitUtil learingExercises(LearingExercises learingExercises) {
        try {
            String[] answerlist = learingExercises.getAnswerlist();
            QueryWrapper<QuestionbankData> questionbankDataQueryWrapper = new QueryWrapper<>();
            questionbankDataQueryWrapper.eq("chapter",learingExercises.getChapterid());
            List<QuestionbankData> questionbankData = questionbankDataMapper.selectList(questionbankDataQueryWrapper);
            int x=100/questionbankData.size();
            int y=0;
            int sum=0;
            for (QuestionbankData questionbankDatum : questionbankData) {
                if (answerlist[y]==questionbankDatum.getCorrectAnswer()){
                    sum = sum + x;
                    y++;
                }
            }
            UpdateWrapper<UserData> update = Wrappers.update();
            update.eq("name",learingExercises.getLearningPeopleName());
            if (learingExercises.getChapterid() == "1"){
                update.set("topic1",sum);
            }
            if (learingExercises.getChapterid() == "2"){
                update.set("topic2",sum);
            }
            if (learingExercises.getChapterid() == "3"){
                update.set("topic3",sum);
            }
            userDataMapper.update(null,update);

            RecordingData recordingData = new RecordingData();
            recordingData.setTimes(LocalDateTime.now());
            recordingData.setLearningPeopleName(learingExercises.getLearningPeopleName());
            recordingData.setChapter(learingExercises.getChapterid());
            recordingData.setFraction(sum);
            recordingDataMapper.insert(recordingData);
            return SubmitUtil.ok();
        }catch (Exception e){
            return SubmitUtil.fail();
        }

    }
}
