package com.etr.portal.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chat")
public class ChatController {

    @GetMapping("/fetch-all/{userId}")
    public ResponseEntity<?> getAllChatsOfUser (String userId) {
        return new ResponseEntity<>();
    }
}
