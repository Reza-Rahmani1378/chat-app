package com.chatapp.chatapp.service;

import com.chatapp.chatapp.model.Group;
import com.chatapp.chatapp.repository.GroupRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
    private final GroupRepository repository;
    private final UserService userService;

    @Override
    public Group findById(Long id) {
        return getById(id);
    }

    @Override
    public Group create(Group group) {
        return repository.save(group);
    }

    @Override
    public List<Group> findAll() {
        return repository.findAll();
    }

    @Override
    public Group addMember(Long groupId, String username) {
        var user = userService.findByUsername(username);
        var group = getById(groupId);
        var members = group.getMembers();
        if (!members.contains(user)) {
            members.add(user);
        }
        group.setMembers(members);
        return repository.save(group);

    }




    private EntityNotFoundException getException() {
        throw new EntityNotFoundException("Entity Not found");
    }

    private Group getById(Long id) {
        return repository.findById(id)
                .orElseThrow(this::getException);
    }
}
