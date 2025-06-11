package com.chatapp.chatapp.api.controller;

import com.chatapp.chatapp.api.adapter.GroupAdapter;
import com.chatapp.chatapp.api.controller.dto.GroupInputModel;
import com.chatapp.chatapp.api.controller.dto.GroupOutputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupAdapter adapter;


    @PostMapping
    public GroupOutputModel create(@RequestBody GroupInputModel groupInputModel) {
        return adapter.createGroup(groupInputModel);
    }


    @GetMapping
    public List<GroupOutputModel> getAll() {
        return adapter.getAllGroups();
    }

    @PostMapping("/{groupId}/add-member")
    public GroupOutputModel addMember(@PathVariable Long groupId, @RequestParam String username) {
        return adapter.addMember(groupId, username);
    }
}
