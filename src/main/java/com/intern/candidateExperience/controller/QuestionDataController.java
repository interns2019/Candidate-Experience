package com.intern.candidateExperience.controller;

import com.intern.candidateExperience.dao.QuestionDataDao;
import com.intern.candidateExperience.model.Candidate;
import com.intern.candidateExperience.model.QuestionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionDataController {

    @Autowired
    private QuestionDataDao questionDataDao;

    @GetMapping("/all")
    public List<QuestionData> getAll() {
        List<QuestionData> questions =  questionDataDao.findAll();

        return questions;
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public QuestionData insert(@RequestBody QuestionData question) {

        questionDataDao.insert(question);
        return question;
    }

    @GetMapping("/{id}")
    public QuestionData getById(@PathVariable("id") String id) {
        Optional questionOpt =  questionDataDao.findById(id);
        QuestionData questionData = (QuestionData)questionOpt.get();
        return questionData;
    }


    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public QuestionData updateQuestion(@RequestBody QuestionData question ){
            questionDataDao.save(question);
            return question;
    }

    @DeleteMapping("/{id}")
    public QuestionData deleteQuestion(@PathVariable String id){
        Optional questionOpt =  questionDataDao.findById(id);
        QuestionData questionData = (QuestionData)questionOpt.get();
        questionData.setVisible(false);
        questionDataDao.save(questionData);
        return questionData;
    }
}
