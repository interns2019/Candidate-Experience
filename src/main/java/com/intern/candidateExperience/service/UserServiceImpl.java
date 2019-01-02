package com.intern.candidateExperience.service;


import com.intern.candidateExperience.dao.UserDao;
import com.intern.candidateExperience.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void save(User user) {
        this.userDao.save(user);
    }

    @Override
    public void deleteAll() {
        this.userDao.deleteAll();
    }

}
