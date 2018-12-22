package com.intern.candidateExperience.controller;

import com.intern.candidateExperience.model.Candidate;
import com.intern.candidateExperience.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/feedback")
//@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {


    @Autowired
    private CandidateService candidateService;

    @GetMapping("/all")
    public List<Candidate> getAllCandidates(){
        return candidateService.getAllCandidates();
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public Candidate insert(@RequestBody Candidate candidate){
       candidateService.save(candidate);
       return candidate;
    }
}