package com.intern.candidateExperience.service;

import com.intern.candidateExperience.model.User;

public interface UserService {
    User findByUsername(String username);

    void save(User user);
    void deleteAll();
}

