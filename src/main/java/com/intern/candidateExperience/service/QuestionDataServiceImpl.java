package com.intern.candidateExperience.service;

import com.intern.candidateExperience.dao.QuestionDataDao;
import com.intern.candidateExperience.model.QuestionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionDataServiceImpl implements QuestionDataService {

    @Autowired
    private QuestionDataDao questionDataDao;

    private List<QuestionData> questions;

    @Override
    public List<QuestionData> getAllQuestions() {
        questions = questionDataDao.findAll();
        return questions;
    }

    @Override
    public void deleteAll() {
        questionDataDao.deleteAll();
    }

    @Override
    public void saveAll(List<QuestionData> questionsData) {
        questionDataDao.saveAll(questionsData);
    }

    @Override
    public void save(QuestionData questionData) {
        questionDataDao.save(questionData);
    }
}
