package com.intern.candidateExperience.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Candidates")
public class Candidate {

    @Id
    private String  id;

    private String candidateName;
    private String candidateCompanyName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Candidate(){

    }
    public Candidate(String candidateName, String candidateCompanyName) {
        this.candidateName = candidateName;
        this.candidateCompanyName = candidateCompanyName;
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
