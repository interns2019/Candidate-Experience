package com.intern.candidateExperience.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.intern.candidateExperience.dao.UserDao;
import com.intern.candidateExperience.model.QuestionData;
import com.intern.candidateExperience.model.Token;
import com.intern.candidateExperience.model.User;
import com.intern.candidateExperience.service.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

//    // this is the login api/service
//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    public Principal user(Principal principal) {
//        logger.info("user logged "+principal);
//        return principal;
//    }

    @GetMapping("/all")
    public List<User> loginGet(){
        return userDao.findAll();
    }

    @PostMapping(value = "/login",produces= MediaType.APPLICATION_JSON_VALUE)
    public Token login(@RequestBody User user) {
        User userCheck = userService.findByUsername(user.getUsername());

        if(userCheck != null ){
            if((userCheck.getPassword()).equals(user.getPassword())){
               try{
                   Algorithm algorithm = Algorithm.HMAC256("secret");
                   Token tokenObj = new Token();
                   String token = JWT.create()
                           .withSubject(userCheck.getId())
                           .withIssuer("auth0")
                           .sign(algorithm);
                   tokenObj.setToken(token);
                   return tokenObj;
               }catch (JWTCreationException exception){
                    exception.printStackTrace();
               }
            }else {
              return null;
            }
        }else{
          return null;
        }
        return null;
    }

    @PostMapping(value = "/login/admin",produces= MediaType.APPLICATION_JSON_VALUE)
    public Token loginAdmin(@RequestBody User user) {
        User userCheck = userService.findByUsername(user.getUsername());

        if(userCheck != null ){
            if((userCheck.getPassword()).equals(user.getPassword())){
                try{
                    Algorithm algorithm = Algorithm.HMAC256("secret");
                    Token tokenObj = new Token();
                    String token = JWT.create()
                            .withSubject(userCheck.getId())
                            .withIssuer("auth0")
                            .sign(algorithm);
                    tokenObj.setToken(token);
                    return tokenObj;
                }catch (JWTCreationException exception){
                    exception.printStackTrace();
                }
            }else {
                return null;
            }
        }else{
            return null;
        }
        return null;
    }
}
