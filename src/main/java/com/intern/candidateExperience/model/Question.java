package com.intern.candidateExperience.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Question {

    private int questionNo;
    private String questionName;
    private int questionRating;
    private boolean visible;


    public Question(){

    }

    public Question(int questionNo, String questionName, int questionRating, boolean visible) {
        this.questionNo = questionNo;
        this.questionName = questionName;
        this.questionRating = questionRating;
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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
