package com.codingninjas.EVotingSystem.services;

import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> response=new ArrayList<>();
        userRepository.findAll().forEach(user -> response.add(user));
        return response;
    }

    public void addVoter(User user) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encodedPass= encoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        userRepository.save(user);
    }
}
