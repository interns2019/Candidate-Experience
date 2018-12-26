package com.intern.candidateExperience.dao;

import com.intern.candidateExperience.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CandidateDao extends MongoRepository<Candidate,String> {

    @Query("{'date':{$gte: ?0,$lte: ?1}}")
    List<Candidate> findBetweenRangeOfDate(LocalDate startRange, LocalDate endRange);

}
