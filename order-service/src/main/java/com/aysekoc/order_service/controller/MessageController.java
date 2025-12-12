package com.aysekoc.order_service.controller;

import com.aysekoc.order_service.service.KafkaPublisherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaPublisherService kafkaPublisher;

    public MessageController(KafkaPublisherService kafkaPublisher) {
        this.kafkaPublisher = kafkaPublisher;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, String message) {
        kafkaPublisher.sendMessage(topic, message);
        return "Mesaj gönderildi: " + message;
    }
}
