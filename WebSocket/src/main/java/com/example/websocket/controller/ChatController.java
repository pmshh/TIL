package com.example.websocket.controller;

import com.example.websocket.dto.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        chatMessage.setSender(username);
        messagingTemplate.convertAndSend("/topic/" + chatMessage.getRoomId(), chatMessage);
    }

    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        chatMessage.setContent(chatMessage.getSender() + " joined!");
        chatMessage.setType(ChatMessage.MessageType.JOIN);
        messagingTemplate.convertAndSend("/topic/" + chatMessage.getRoomId(), chatMessage);
    }

    @MessageMapping("/chat.leaveUser")
    public void leaveUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        String username = (String) headerAccessor.getSessionAttributes().remove("username");
        chatMessage.setSender(username);
        chatMessage.setContent(username + " left!");
        chatMessage.setType(ChatMessage.MessageType.LEAVE);
        messagingTemplate.convertAndSend("/topic/" + chatMessage.getRoomId(), chatMessage);
    }
}
