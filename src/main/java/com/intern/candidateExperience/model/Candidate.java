package com.intern.candidateExperience.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Document(collection = "Candidates")
public class Candidate {

    @Id
    private String  id;
    private List<Question> questionsAttempted;
    private java.util.Date date;
    private String feedback;
    public Candidate(){

    }

    public Candidate(List<Question> questionsAttempted, java.util.Date date, String feedback) {
        this.questionsAttempted = questionsAttempted;
        this.date = date;
        this.feedback = feedback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Question> getQuestionsAttempted() {
        return questionsAttempted;
    }

    public void setQuestionsAttempted(List<Question> questionsAttempted) {
        this.questionsAttempted = questionsAttempted;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
