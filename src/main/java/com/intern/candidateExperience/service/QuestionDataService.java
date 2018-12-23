package com.intern.candidateExperience.service;

import com.intern.candidateExperience.model.Candidate;
import com.intern.candidateExperience.model.QuestionData;

import java.util.List;

public interface QuestionDataService {
    public List<QuestionData> getAllQuestions();

    public void deleteAll();

    public void saveAll(List<QuestionData> questionsData);

    public void save(QuestionData questionData);
}
