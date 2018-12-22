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

    private List<Candidate> allCandidates;

    @Override
    public List<Candidate> getAllCandidates() {

        allCandidates = candidateDao.findAll();
        return allCandidates;
    }

    @Override
    public void deleteAll() {
        candidateDao.deleteAll();
    }

    @Override
    public void saveAll(List<Candidate> candidates) {
        candidateDao.saveAll(candidates);
    }

    @Override
    public void save(Candidate candidate) {
        candidateDao.save(candidate);
    }


}

