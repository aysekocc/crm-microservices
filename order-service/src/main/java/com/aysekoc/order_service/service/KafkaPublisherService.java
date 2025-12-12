package com.aysekoc.order_service.service;


import com.aysekoc.order_service.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisherService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaPublisherService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        Message msg = new Message(message);
        kafkaTemplate.send(topic, msg);
        System.out.println("Mesaj gönderildi: " + message);
    }
}
