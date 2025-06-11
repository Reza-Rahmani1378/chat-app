package com.chatapp.chatapp.exception;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class WebSocketExceptionHandler {

    @MessageExceptionHandler
    @SendToUser("/topic/errors")
    public ErrorResponse handleException(Exception ex) {
        return new ErrorResponse(
                "WebSocket Error",
                ex.getMessage(),
                LocalDateTime.now()
        );
    }
}
