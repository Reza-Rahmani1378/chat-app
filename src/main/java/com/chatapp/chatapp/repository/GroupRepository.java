package com.chatapp.chatapp.repository;

import com.chatapp.chatapp.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<Group, Long> {
}