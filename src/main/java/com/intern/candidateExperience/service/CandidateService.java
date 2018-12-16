package com.intern.candidateExperience.service;

import com.intern.candidateExperience.model.Candidate;

import java.util.List;

public interface CandidateService {
    public Iterable<Candidate> getAllCandidates();

    public void addCandidateResponse(Candidate candidate);
}
