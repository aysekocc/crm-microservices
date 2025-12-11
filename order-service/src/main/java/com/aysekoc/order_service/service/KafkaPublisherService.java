package com.aysekoc.order_service.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisherService {

    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "send-topic";

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Mesaj gönderildi: " + message);
    }
}