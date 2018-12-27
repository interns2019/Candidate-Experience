package com.intern.candidateExperience;

import com.intern.candidateExperience.model.Candidate;
import com.intern.candidateExperience.model.DateAdded;
import com.intern.candidateExperience.model.Question;
import com.intern.candidateExperience.model.QuestionData;
import com.intern.candidateExperience.service.CandidateService;
import com.intern.candidateExperience.service.QuestionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        String input1 = "2018-08-16" ;
        String input2 = "2018-08-16" ;
        String input3 = "2018-09-16" ;
        String input4 = "2018-10-16" ;
        String input5 = "2018-11-16" ;
        String input6 = "2019-04-04" ;
        String input7 = "2017-12-30" ;
        String input8 = "2017-05-31" ;
        String input9 = "2018-02-28" ;
        String input10 = "2018-01-01" ;

        DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ;

        LocalDate ld1 = LocalDate.parse( input8 , f ) ;
        LocalDate ld2 = LocalDate.parse( input7 , f ) ;
        LocalDate ld3 = LocalDate.parse( input10 , f ) ;
        LocalDate ld4 = LocalDate.parse( input9 , f ) ;
        LocalDate ld5 = LocalDate.parse( input1 , f ) ;
        LocalDate ld6 = LocalDate.parse( input2 , f ) ;
        LocalDate ld7 = LocalDate.parse( input3 , f ) ;
        LocalDate ld8 = LocalDate.parse( input4 , f ) ;
        LocalDate ld9 = LocalDate.parse( input5 , f ) ;
        LocalDate ld10 = LocalDate.parse( input6 , f ) ;

        Question q1 = new Question(1,"How was the interview",6,"Excellent");
        Question q2 = new Question(2,"Was it helpful",9,"Outstanding");
        Question q3 = new Question(1,"How was the interview",5,"Excellent");
        Question q4 = new Question(2,"Was it helpful",8,"Outstanding");
        Question q5 = new Question(1,"How was the interview",7,"Excellent");
        Question q6 = new Question(2,"Was it helpful",8,"Outstanding");
        Question q7 = new Question(3,"are you happy",8,"Outstanding");
        Question q8 = new Question(4,"Was it nice",8,"Outstanding");
        Question q9 = new Question(3,"are you happy",5,"Outstanding");
        Question q10 = new Question(4,"Was it nice",4,"Outstanding");
        Question q11 = new Question(5,"What's your name??",10,"Good");
        List<Question> qList1 = Arrays.asList(q1,q2);
        List<Question> qList2 = Arrays.asList(q3,q4,q7,q8);
        List<Question> qList3 = Arrays.asList(q5,q6,q9,q10);
        List<Question> qlist4 = Arrays.asList(q3,q4,q7,q8,q11);
        List<Question> qList5 = Arrays.asList(q3,q4,q7,q8,q11);

        Candidate c1 = new Candidate(qList1,ld1.plusDays(1),new DateAdded(ld1.plusDays(1).getDayOfMonth(),ld1.plusDays(1).getMonthValue(),ld1.plusDays(1).getYear()),"Kaafi Acha Feedback");
        Candidate c2 = new Candidate(qList2,ld6.plusDays(1),new DateAdded(ld6.plusDays(1).getDayOfMonth(),ld6.plusDays(1).getMonthValue(),ld6.plusDays(1).getYear()),"Aur ek Acha Feedback");
        Candidate c3 = new Candidate(qList1,ld2.plusDays(1),new DateAdded(ld2.plusDays(1).getDayOfMonth(),ld2.plusDays(1).getMonthValue(),ld2.plusDays(1).getYear()),"Ek Feedback");
        Candidate c4 = new Candidate(qList1,ld3.plusDays(1),new DateAdded(ld3.plusDays(1).getDayOfMonth(),ld3.plusDays(1).getMonthValue(),ld3.plusDays(1).getYear()),"2 Feedback");
        Candidate c5 = new Candidate(qList1,ld4.plusDays(1),new DateAdded(ld4.plusDays(1).getDayOfMonth(),ld4.plusDays(1).getMonthValue(),ld4.plusDays(1).getYear()),"3 Feedback");
        Candidate c6 = new Candidate(qList3,ld5.plusDays(1),new DateAdded(ld5.plusDays(1).getDayOfMonth(),ld5.plusDays(1).getMonthValue(),ld5.plusDays(1).getYear()),"4 Feedback");
        Candidate c7 = new Candidate(qList3,ld7.plusDays(1),new DateAdded(ld7.plusDays(1).getDayOfMonth(),ld7.plusDays(1).getMonthValue(),ld7.plusDays(1).getYear()),"4 Feedback");
        Candidate c8 = new Candidate(qList2,ld8.plusDays(1),new DateAdded(ld8.plusDays(1).getDayOfMonth(),ld8.plusDays(1).getMonthValue(),ld8.plusDays(1).getYear()),"4 Feedback");
        Candidate c9 = new Candidate(qList5,ld9.plusDays(1),new DateAdded(ld9.plusDays(1).getDayOfMonth(),ld9.plusDays(1).getMonthValue(),ld9.plusDays(1).getYear()),"4 Feedback");
        Candidate c10 = new Candidate(qlist4,ld10.plusDays(1),new DateAdded(ld10.plusDays(1).getDayOfMonth(),ld10.plusDays(1).getMonthValue(),ld10.plusDays(1).getYear()),"4 Feedback");

        QuestionData qd1 = new QuestionData(1,"How was the interview");
        QuestionData qd2 = new QuestionData(2,"Was it helpful");
        QuestionData qd3 = new QuestionData(3,"are you happy");
        QuestionData qd4 = new QuestionData(4,"Was it nice");
        QuestionData qd5 = new QuestionData(5,"What's your name??");

        //Drop All Entries
        candidateService.deleteAll();
        questionDataService.deleteAll();

        //add our entries to the database
//        List<Candidate> candidates = Arrays.asList(c1,c3,c4,c5,c6,c2,c7,c8,c9,c10);
//        List<QuestionData> questionDataList = Arrays.asList(qd1,qd2,qd3,qd4,qd5);
//        candidateService.saveAll(candidates);
//        questionDataService.saveAll(questionDataList);
    }
}
