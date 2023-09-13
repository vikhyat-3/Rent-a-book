package com.spring.RentABook.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RentABook.entity.User;
import com.spring.RentABook.repository.UserRepository;

@Service
public class userServiceImpl implements userService{
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User createNewUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserByID(String userID){
        User p=userRepository.findById(userID).get();
        return p;
    }
}
