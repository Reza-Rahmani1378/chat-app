package com.chatapp.chatapp.api.adapter;

import com.chatapp.chatapp.api.adapter.mapper.UserMapper;
import com.chatapp.chatapp.api.controller.dto.UserInputModel;
import com.chatapp.chatapp.api.controller.dto.UserOutputModel;
import com.chatapp.chatapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapter {

    private final UserService service;
    private final UserMapper mapper;

    public UserOutputModel createUser(UserInputModel userInputModel) {
        var user = mapper.getEntityFromUserInputModel(userInputModel);
        return mapper.getUserOutputModelFromEntity(service.create(user));
    }

    public List<UserOutputModel> getAllUsers() {

        return service.findAll()
                .stream()
                .map(mapper::getUserOutputModelFromEntity)
                .toList();
    }
}
