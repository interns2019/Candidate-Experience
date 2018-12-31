package com.intern.candidateExperience.service;


import com.intern.candidateExperience.dao.UserDao;
import com.intern.candidateExperience.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user from the database (throw exception if not found)
        User user = userDao.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Return user object
        return user;
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
