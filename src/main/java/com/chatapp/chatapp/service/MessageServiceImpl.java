package com.chatapp.chatapp.service;

import com.chatapp.chatapp.model.Message;
import com.chatapp.chatapp.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{
    private final MessageRepository repository;

    @Override
    public Message create(Message message) {
        return repository.save(message);
    }
}
