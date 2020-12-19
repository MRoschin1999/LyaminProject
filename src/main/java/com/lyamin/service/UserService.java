package com.lyamin.service;

import com.lyamin.pojo.Film;
import com.lyamin.pojo.User;
import com.lyamin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(){
        long maxId = 0L;
        Iterable<User> userList = userRepository.findAll();
        for (User value : userList) {
            long id = value.getId();
            if (maxId < id) {
                maxId = id;
            }
        }
        maxId++;
        User user = new User(maxId);
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new NullPointerException();
        }
        return user.get();
    }
}
