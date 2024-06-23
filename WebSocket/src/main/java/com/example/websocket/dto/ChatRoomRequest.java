package com.example.websocket.dto;

import lombok.Data;

@Data
public class ChatRoomRequest {
    private String roomName;
    private String userName;

}
