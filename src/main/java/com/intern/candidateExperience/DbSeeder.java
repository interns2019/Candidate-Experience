package com.intern.candidateExperience;

import com.intern.candidateExperience.model.Candidate;
import com.intern.candidateExperience.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    public CandidateService candidateService;
    @Override
    public void run(String... args) throws Exception {
        Candidate c1 = new Candidate("Amaan","XYZ");
        Candidate c2 = new Candidate("Akshay","ABC");

        //Drop All Hotel
        candidateService.deleteAll();

        //add our hotels to the database
        List<Candidate> candidates = Arrays.asList(c1,c2);

        candidateService.saveAll(candidates);
    }
}
