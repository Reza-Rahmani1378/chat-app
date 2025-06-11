package com.chatapp.chatapp.api.adapter.mapper;

import com.chatapp.chatapp.api.controller.dto.MessageInputModel;
import com.chatapp.chatapp.api.controller.dto.MessageOutputModel;
import com.chatapp.chatapp.model.Group;
import com.chatapp.chatapp.model.Message;
import com.chatapp.chatapp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {




    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "version" , ignore = true)
    @Mapping(target = "isDeleted" , ignore = true)
    @Mapping(target = "createdDate" , ignore = true)
    Message getEntityFromMessageInputModel(MessageInputModel messageInputModel, User sender, Group group);


    @Mapping(target = "senderName", source = "sender.username")
    MessageOutputModel getMessageOutputModelFromEntity(Message message);


}
