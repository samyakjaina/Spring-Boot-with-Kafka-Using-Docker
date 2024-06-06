package com.example.kafkaDocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaDocker.domain.KafkaRequest;

@RestController
public class KafkaController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@PostMapping("/send")
	public String sendMessage(@RequestBody KafkaRequest kafkaRequest) {
		kafkaProducer.sendMessage("new-topic", kafkaRequest);
		for (int i = 0; i < kafkaRequest.getCoun(); i++) {
			kafkaProducer.sendMessage("new-topic",kafkaRequest);
		}
		return "Message sent: " + kafkaRequest.getData();
	}

	@PostMapping("/call")
	public String call() {
		return "Message sent: ";
	}
}
