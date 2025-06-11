package com.chatapp.chatapp.service;

import com.chatapp.chatapp.model.Group;

import java.util.List;

public interface GroupService {
    Group findById(Long id);
    Group create(Group group);
    List<Group> findAll();

    Group addMember(Long groupId, String username);
}
