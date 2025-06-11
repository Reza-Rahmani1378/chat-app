package com.chatapp.chatapp.api.adapter;

import com.chatapp.chatapp.api.adapter.mapper.MessageMapper;
import com.chatapp.chatapp.api.controller.dto.MessageInputModel;
import com.chatapp.chatapp.api.controller.dto.MessageOutputModel;
import com.chatapp.chatapp.model.Group;
import com.chatapp.chatapp.model.User;
import com.chatapp.chatapp.service.GroupService;
import com.chatapp.chatapp.service.MessageService;
import com.chatapp.chatapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageAdapter {

    private final MessageMapper mapper;
    private final MessageService service;
    private final UserService userService;
    private final GroupService groupService;
    private final SimpMessagingTemplate simpMessagingTemplate;



    public MessageOutputModel handleInComingMessage(MessageInputModel messageInputModel, Long groupId) {
        var user = getUserWithUsername(messageInputModel.getSenderName());
        var group = getGroupWithId(groupId);
        var message = mapper.getEntityFromMessageInputModel(messageInputModel, user, group);

        message = service.create(message);

        return mapper.getMessageOutputModelFromEntity(message);
    }







    private User getUserWithUsername(String username) {
        return userService.findByUsername(username);
    }


    private Group getGroupWithId(Long id) {
        return groupService.findById(id);
    }



}
