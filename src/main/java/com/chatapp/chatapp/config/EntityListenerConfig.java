package com.chatapp.chatapp.config;

import com.chatapp.chatapp.config.model.EntityListener;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EntityListenerConfig {


    @Bean
    public EntityListener entityListener() {
        return new EntityListener();
    }
}
