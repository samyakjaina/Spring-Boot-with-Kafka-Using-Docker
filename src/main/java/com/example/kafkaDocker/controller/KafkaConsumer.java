package com.example.kafkaDocker.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.kafkaDocker.domain.KafkaRequest;

@Component
public class KafkaConsumer {
	@KafkaListener(topics = "new-topic", groupId = "samyak-group-id")
	public void listen(KafkaRequest message) {
		System.out.println("Received message: " + message);
	}
}
