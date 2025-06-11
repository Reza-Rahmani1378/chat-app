package com.chatapp.chatapp.config.model;

import com.chatapp.chatapp.model.BaseEntity;
import jakarta.persistence.PrePersist;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EntityListener {

  public EntityListener() {

  }


  @PrePersist
  public void onCreate(BaseEntity entity) {
    if (entity.getCreatedDate() == null) {
      entity.setCreatedDate(LocalDateTime.now());
    }
  }
}
