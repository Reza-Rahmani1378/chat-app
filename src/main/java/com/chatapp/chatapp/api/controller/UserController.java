package com.chatapp.chatapp.api.controller;

import com.chatapp.chatapp.api.adapter.UserAdapter;
import com.chatapp.chatapp.api.controller.dto.UserInputModel;
import com.chatapp.chatapp.api.controller.dto.UserOutputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserAdapter adapter;


    @PostMapping
    public UserOutputModel create(@RequestBody UserInputModel userInputModel) {
        return adapter.createUser(userInputModel);
    }


    @GetMapping
    public List<UserOutputModel> getAll() {
        return adapter.getAllUsers();
    }
}
