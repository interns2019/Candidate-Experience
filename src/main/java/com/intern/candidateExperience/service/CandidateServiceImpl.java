package com.intern.candidateExperience.service;

import com.intern.candidateExperience.dao.CandidateDao;
import com.intern.candidateExperience.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDao candidateDao;

    private Iterable<Candidate> allCandidates;
    @Override
    public Iterable<Candidate> getAllCandidates() {

        allCandidates = candidateDao.findAll();
        return allCandidates;
    }

    @Override
    public void addCandidateResponse(Candidate candidate) {
        candidateDao.save(candidate);
    }
}
