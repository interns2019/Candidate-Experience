package com.intern.candidateExperience.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;
    private String candidateCompanyName;

    public Candidate(){

    }
    public Candidate(String candidateName, String candidateCompanyName) {
        this.candidateName = candidateName;
        this.candidateCompanyName = candidateCompanyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
