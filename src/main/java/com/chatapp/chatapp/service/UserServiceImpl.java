package com.chatapp.chatapp.service;

import com.chatapp.chatapp.model.User;
import com.chatapp.chatapp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow( () -> new EntityNotFoundException("User with this username:  " + username + "not found."));
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("User with this id:  " + id + "not found."));
    }
}
