package com.etr.portal.controller;

import com.etr.model.ChatObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Chat controller.
 */
@RestController
@RequestMapping("chat")
public class ChatController {

    /**
     * Gets all chats of user.
     *
     * @param userId the user id
     * @return the all chats of user
     */
    @GetMapping("/fetch-all/{userId}")
    public ResponseEntity<?> getAllChatsOfUser (String userId) {
        return ResponseEntity.ok(new ChatObject());
    }
}
