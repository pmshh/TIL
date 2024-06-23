package com.example.websocket.service;

import com.example.websocket.entity.ChatRoom;
import com.example.websocket.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom findById(Long id) {
        return chatRoomRepository.findById(id).orElse(null);
    }

    public ChatRoom save(String roomName, String userName) {
        return chatRoomRepository.save(new ChatRoom(roomName, userName));
    }
}

