package com.chatapp.chatapp.api.adapter.mapper;

import com.chatapp.chatapp.api.controller.dto.UserInputModel;
import com.chatapp.chatapp.api.controller.dto.UserOutputModel;
import com.chatapp.chatapp.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User getEntityFromUserInputModel(UserInputModel userInputModel);

    UserOutputModel getUserOutputModelFromEntity(User user);


}
