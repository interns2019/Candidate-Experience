package com.intern.candidateExperience.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Question {

    @Id
    private String id;
    private int questionNo;
    private String questionName;
    private int questionRating;
    private String questionOverall;

    public Question(int questionNo, String questionName, int questionRating, String questionOverall) {
        this.questionNo = questionNo;
        this.questionName = questionName;
        this.questionRating = questionRating;
        this.questionOverall = questionOverall;
    }

    public String getQuestionOverall() {
        return questionOverall;
    }

    public void setQuestionOverall(String questionOverall) {
        this.questionOverall = questionOverall;
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

    public int getQuestionRating() {
        return questionRating;
    }

    public void setQuestionRating(int questionRating) {
        this.questionRating = questionRating;
    }

}
