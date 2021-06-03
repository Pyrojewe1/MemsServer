package com.example.memes.service;

import com.example.memes.dao.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public Long verifyUser(String username, String password){
        return userRepository.verifyUser(username,password);
    }
}
