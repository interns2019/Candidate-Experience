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

    @Query("{'date.year':?0}")
    List<Candidate> findByYear(int year);

    @Query("{'date.month':?0}")
    List<Candidate> findByMonth(int month);

    @Query("{$and:[{'date.year':?0},{'date.month':?1}]}")
    List<Candidate> findByYearAndMonth(int year, int month);

}
