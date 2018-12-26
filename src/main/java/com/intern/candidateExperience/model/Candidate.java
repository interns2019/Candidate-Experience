package com.intern.candidateExperience.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;


@Document(collection = "Candidates")
public class Candidate {

    @Id
    private String  id;
    private List<Question> questionsAttempted;
    private LocalDate localDate;
    private DateAdded date;
    private String feedback;
    public Candidate(){

    }


    public Candidate(List<Question> questionsAttempted, LocalDate localDate, DateAdded date, String feedback) {
        this.questionsAttempted = questionsAttempted;
        this.localDate = localDate;
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDated) {
        this.localDate = localDate;
    }

    public DateAdded getDate() {
        return date;
    }

    public void setDate(DateAdded date) {
        this.date = date;
    }
}
