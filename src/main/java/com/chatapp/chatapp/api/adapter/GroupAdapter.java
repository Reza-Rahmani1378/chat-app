package com.chatapp.chatapp.api.adapter;

import com.chatapp.chatapp.api.adapter.mapper.GroupMapper;
import com.chatapp.chatapp.api.controller.dto.GroupInputModel;
import com.chatapp.chatapp.api.controller.dto.GroupOutputModel;
import com.chatapp.chatapp.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GroupAdapter {

    private final GroupService service;
    private final GroupMapper mapper;

    public GroupOutputModel createGroup(GroupInputModel groupInputModel) {
        var group = mapper.getEntityFromGroupInputModel(groupInputModel);
        return mapper.getOutputModelFromEntity(service.create(group));
    }

    public List<GroupOutputModel> getAllGroups() {
        return service.findAll()
                .stream()
                .map(mapper::getOutputModelFromEntity)
                .toList();
    }

    public GroupOutputModel addMember(Long groupId, String username) {
        var group = service.addMember(groupId, username);
        return mapper.getOutputModelFromEntity(group);
    }
}
