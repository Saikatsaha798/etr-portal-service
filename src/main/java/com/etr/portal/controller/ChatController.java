package com.etr.portal.controller;

import com.etr.model.ChatObject;
import com.etr.model.MessageObject;
import com.etr.portal.kafka.KafkaMessageProducer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Chat controller.
 */
@RestController
@RequestMapping("chat")
@RequiredArgsConstructor
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);
    private final KafkaMessageProducer kafkaMessageProducer;

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


    /**
     * Send message response entity.
     *
     * @param message the message
     * @return the response entity
     */
    @PostMapping("/message/send")
    public ResponseEntity<?> sendMessage (@RequestBody MessageObject message) {
        log.info("Message sent by {}", message.getSenderId());

        kafkaMessageProducer.publishMessage(message);

        return ResponseEntity.ok("Message sent!");
    }
}
