package com.intern.candidateExperience;

import com.intern.candidateExperience.model.Candidate;
import com.intern.candidateExperience.model.Question;
import com.intern.candidateExperience.model.QuestionData;
import com.intern.candidateExperience.service.CandidateService;
import com.intern.candidateExperience.service.QuestionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private QuestionDataService questionDataService;

    @Override
    public void run(String... args) throws Exception {
        Question q1 = new Question("Q1","How was the interview",6);
        Question q2 = new Question("Q2","Was it helpful",9);

        List<Question> qList1 = Arrays.asList(q1,q2);
        Candidate c1 = new Candidate(qList1,new java.util.Date(),"Kaafi Acha Feedback");
        Candidate c2 = new Candidate(qList1,new java.util.Date(),"Aur ek Acha Feedback");

        QuestionData qd1 = new QuestionData("Q1","How was the interview");
        QuestionData qd2 = new QuestionData("Q2","Was it helpful");

        //Drop All Entries
        candidateService.deleteAll();
        questionDataService.deleteAll();

        //add our entries to the database
        List<Candidate> candidates = Arrays.asList(c1,c2);
        List<QuestionData> questionDataList = Arrays.asList(qd1,qd2);
        candidateService.saveAll(candidates);
        questionDataService.saveAll(questionDataList);
    }
}
