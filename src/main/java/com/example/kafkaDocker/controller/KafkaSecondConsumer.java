package com.example.kafkaDocker.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.kafkaDocker.domain.KafkaRequest;

@Component
public class KafkaSecondConsumer {
	@KafkaListener(topics = "new-topic", groupId = "samyak-group-id")
	public void listens(KafkaRequest message) {
		System.out.println("Samyak  message: " + message);
	}
	
	@KafkaListener(topics = "new-topic", groupId = "samyak-group-id")
	public void listensss(KafkaRequest message) {
		System.out.println("demo message: " + message);
	}
}
