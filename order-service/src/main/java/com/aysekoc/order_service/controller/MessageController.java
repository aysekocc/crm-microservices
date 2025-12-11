package com.aysekoc.order_service.controller;

import com.aysekoc.order_service.service.KafkaPublisherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {


    private final KafkaPublisherService kafkaProducer;

    public MessageController(KafkaPublisherService kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return "Mesaj gönderildi: " + message;
    }
}
