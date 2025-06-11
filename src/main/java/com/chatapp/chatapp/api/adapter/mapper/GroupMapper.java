package com.chatapp.chatapp.api.adapter.mapper;

import com.chatapp.chatapp.api.controller.dto.GroupInputModel;
import com.chatapp.chatapp.api.controller.dto.GroupOutputModel;
import com.chatapp.chatapp.model.Group;
import com.chatapp.chatapp.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupOutputModel getOutputModelFromEntity(Group group);

    Group getEntityFromGroupInputModel(GroupInputModel groupInputModel);

    @AfterMapping
    default void fillMemberUsernames(Group group, @MappingTarget GroupOutputModel dto) {
        var members = group.getMembers();
        if (!CollectionUtils.isEmpty(members)) {
            List<String> usernames = members
                    .stream()
                    .map(User::getUsername)
                    .toList();
            dto.setMemberUsernames(usernames);
        }
    }
}
