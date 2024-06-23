package com.example.websocket.controller;

import com.example.websocket.dto.ChatRoomRequest;
import com.example.websocket.entity.ChatRoom;
import com.example.websocket.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatrooms")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @GetMapping
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomService.findAll();
    }

    @PostMapping
    public ChatRoom createChatRoom(@RequestBody ChatRoomRequest request) {
        return chatRoomService.save(request.getRoomName(), request.getUserName());
    }
}

