package com.chatapp.chatapp.service;

import com.chatapp.chatapp.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    User create(User user);
    List<User> findAll();

    User findById(Long id);
}
