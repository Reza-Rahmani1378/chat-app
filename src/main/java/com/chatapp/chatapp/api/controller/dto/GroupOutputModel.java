package com.chatapp.chatapp.api.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupOutputModel {
    private Long id;
    private String name;
    private String title;
    private String description;
    private List<String> memberUsernames;
}
