package com.intern.candidateExperience.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Candidates")
public class Candidate {

    @Id
    private String  id;
    private String refId;
    private String candidateName;
    private String candidateCompanyName;
    private String feedback;

    public Candidate(){

    }

    public Candidate(String refId, String candidateName, String candidateCompanyName, String feedback) {
        this.refId = refId;
        this.candidateName = candidateName;
        this.candidateCompanyName = candidateCompanyName;
        this.feedback = feedback;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateCompanyName() {
        return candidateCompanyName;
    }

    public void setCandidateCompanyName(String candidateCompanyName) {
        this.candidateCompanyName = candidateCompanyName;
    }
}
