package com.intern.candidateExperience.controller;

import com.intern.candidateExperience.model.Candidate;
import com.intern.candidateExperience.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private CandidateService candidateService;

    //Home Page
    @RequestMapping(value = "/")
    @ResponseBody
    public String home(){
        candidateService.addCandidateResponse(new Candidate("Amaan","XYZ"));
        candidateService.addCandidateResponse(new Candidate("Akshay","ABC"));
        return "Candidate Experience System";
    }
}