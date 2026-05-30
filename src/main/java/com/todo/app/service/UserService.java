package com.todo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.entity.User;
import com.todo.app.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User login(String email, String password) {

        User user = userRepo.findByEmail(email);

        System.out.println("DB User = " + user);

        if (user != null) {
            System.out.println("DB Password = " + user.getPassword());
            System.out.println("Entered Password = " + password);
        }

        if (user != null &&
            user.getPassword() != null &&
            user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}