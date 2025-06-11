package com.chatapp.chatapp.api.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageOutputModel {
    private String senderName;
    private String content;
    private LocalDateTime createdDate;
}
