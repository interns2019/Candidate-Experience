package com.intern.candidateExperience.dao;

import com.intern.candidateExperience.model.QuestionData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDataDao extends MongoRepository<QuestionData,String> {
}
