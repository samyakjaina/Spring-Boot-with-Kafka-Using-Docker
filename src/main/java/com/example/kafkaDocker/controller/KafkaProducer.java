package com.example.kafkaDocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.kafkaDocker.domain.KafkaRequest;

@Component
public class KafkaProducer {
	@Autowired
    private KafkaTemplate<String, KafkaRequest> kafkaTemplate;

    public void sendMessage(String topic, KafkaRequest message) {
        kafkaTemplate.send(topic, message);
    }
}
