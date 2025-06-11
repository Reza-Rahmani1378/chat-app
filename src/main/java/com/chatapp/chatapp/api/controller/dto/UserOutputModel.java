package com.chatapp.chatapp.api.controller.dto;

import lombok.Data;

@Data
public class UserOutputModel {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
}
