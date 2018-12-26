package com.intern.candidateExperience.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "QuestionsData")
public class QuestionData {

    @Id
    private String id;
    private int questionNo;
    private String questionName;

    public QuestionData(int questionNo, String questionName) {
        this.questionNo = questionNo;
        this.questionName = questionName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }
}

