package com.chatapp.chatapp.api.controller;

import com.chatapp.chatapp.api.adapter.MessageAdapter;
import com.chatapp.chatapp.api.controller.dto.MessageInputModel;
import com.chatapp.chatapp.api.controller.dto.MessageOutputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final MessageAdapter adapter;

    @MessageMapping("/chat.sendMessage/{groupId}")
    @SendTo("/topic/messages/{groupId}")
    public MessageOutputModel handleMessage(@DestinationVariable Long groupId,
                                            @Payload MessageInputModel messageInputModel) {
        return adapter.handleInComingMessage(messageInputModel, groupId);
    }
}