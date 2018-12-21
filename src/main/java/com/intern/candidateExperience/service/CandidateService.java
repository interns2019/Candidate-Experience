package com.intern.candidateExperience.service;

import com.intern.candidateExperience.model.Candidate;

import java.util.List;

public interface CandidateService {
    public List<Candidate> getAllCandidates();

    public void deleteAll();

    public void saveAll(List<Candidate> candidates);

}
