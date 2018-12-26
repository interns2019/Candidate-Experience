package com.intern.candidateExperience.controller;

import com.intern.candidateExperience.dao.CandidateDao;
import com.intern.candidateExperience.dao.QuestionDataDao;
import com.intern.candidateExperience.model.Candidate;
import com.intern.candidateExperience.model.Question;
import com.intern.candidateExperience.model.QuestionData;
import com.intern.candidateExperience.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/feedback")
//@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

    String input1 = "2017-01-01" ;
    String input2 = "2018-12-31" ;

    DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ;

    LocalDate ld1 = LocalDate.parse( input1 , f ) ;
    LocalDate ld2 = LocalDate.parse( input2 , f ) ;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateDao candidateDao;

    @Autowired
    private QuestionDataDao questionDataDao;



    @GetMapping("/all")
    public List<Candidate> getAllCandidates(){
        return candidateService.getAllCandidates();
    }


    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public Candidate insert(@RequestBody Candidate candidate){
       candidateService.save(candidate);
       return candidate;
    }

    @GetMapping("/range")
    public HashMap<Integer,Double> findByRange(){
        List<Candidate> candidatesFilter = candidateDao.findBetweenRangeOfDate(ld1,ld2);
        HashMap<Integer,Double> answer = avgAnalysis(candidatesFilter);
        return answer;
    }

    public HashMap<Integer,Double> avgAnalysis(List<Candidate> candidates1){

        List<Candidate> candidates = inSync(candidates1);
        HashMap<Integer, Double> questionAverage = new HashMap<>();

        //Candidate[] candidateArray = candidates.toArray(new Candidate[candidates.size()]);

        Candidate[] candidateArray = new Candidate[candidates.size()];

        for(int k=0; k<candidates.size(); k++){
            candidateArray[k] = candidates.get(k);
        }
        //candidateArray = (Candidate[])candidates.toArray();

        //Length of Filtered Candidate List based on Date range
        int len = candidateArray.length;

        //Number of questions in the DB
        int qcount = (int)questionDataDao.count();

        long sum = 0;
        double avg = 0.0;

        //Number of people attempted the question
        long countC = 0;


        for(int j=0; j<qcount; j++){
            for(int i=0; i<len; i++){
                try{
                    int val = candidateArray[i].getQuestionsAttempted().get(j).getQuestionRating();
                    sum = sum + val;
                    if(val>0){
                        countC++;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    e.printStackTrace();
                }
            }
            if(countC>0){
                avg = ((double)sum/countC);
            }
            questionAverage.put(j+1,avg);
            sum = 0;
            countC = 0;
            avg = 0.0;

        }

        return questionAverage;
    }

    private List<Candidate> inSync(List<Candidate> candidates) {
        long currentCount = questionDataDao.count();
        for(int i=0; i<candidates.size(); i++){
            Candidate candidate = candidates.get(i);
            long count = candidate.getQuestionsAttempted().size();

            for(long j=count; j<currentCount;j++){
                if(j>=count) {
                    Question sampleQuestion = new Question((int)(j+1),"",0,"");
                    candidate.getQuestionsAttempted().add(sampleQuestion);
                    candidateService.save(candidate);
                }

            }
        }
        return candidateService.getAllCandidates();
    }

}