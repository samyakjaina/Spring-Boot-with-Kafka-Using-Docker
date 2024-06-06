package com.example.kafkaDocker.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaConfig {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private final String bootstrapServers = "localhost:9092";

	@Bean
	public NewTopic taskTopic() {
		return TopicBuilder.name("new-topic").partitions(100).replicas(1).build();
	}

//	for dynamically creates the topic 
//	@Bean
//	public AdminClient adminClient() {
//		Map<String, Object> configs = new HashMap<>();
//		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//		return AdminClient.create(configs);
//	}
//
//	@Bean
//	public ProducerInterceptor<String, String> topicCreationInterceptor() {
//		return new ProducerInterceptor<String, String>() {
//			@Override
//			public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
//				// Check if the topic exists
//				String topic = record.topic();
//				try {
//					if (!adminClient().listTopics().names().get().contains(topic)) {
//						// If the topic doesn't exist, create it
//						adminClient().createTopics(Collections.singletonList(new NewTopic(topic, 1, (short) 1)));
//					}
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ExecutionException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return record;
//			}
//
//			@Override
//			public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
//				// No operation needed
//			}
//
//			@Override
//			public void close() {
//				// No operation needed
//			}
//
//			@Override
//			public void configure(Map<String, ?> configs) {
//				// No operation needed
//			}
//		};
//	}
//
//	@Bean
//	public KafkaTemplate<String, String> kafkaTemplate() {
//		Map<String, Object> props = new HashMap<>();
//		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//				"org.apache.kafka.common.serialization.StringSerializer");
//		props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, List.of(topicCreationInterceptor())); // Add the
//																									// interceptor
//		return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(props));
//	}

}