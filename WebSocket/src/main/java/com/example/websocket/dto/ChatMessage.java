package com.example.websocket.dto;

import lombok.Data;

@Data
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;
    private String roomId;
    private String username;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }
}


