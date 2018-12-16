package com.intern.candidateExperience.dao;

import com.intern.candidateExperience.model.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends CrudRepository<Candidate,Long> {
}
