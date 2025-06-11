package com.chatapp.chatapp.api.controller.dto;

import lombok.Data;

@Data
public class MessageInputModel {
    private String senderName;
    private String content;
}
