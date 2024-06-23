package com.example.websocket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomName;
    private String userName;

    public ChatRoom() {}

    public ChatRoom(String roomName, String userName) {
        this.roomName = roomName;
        this.userName = userName;
    }
}
