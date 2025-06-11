package com.chatapp.chatapp.model;

import com.chatapp.chatapp.config.model.EntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(value = EntityListener.class)
public class BaseEntity {

    @Version
    protected Long version;

    @Column(name = "deleted")
    protected Boolean isDeleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(name = "created_date")
    protected LocalDateTime createdDate;
}
