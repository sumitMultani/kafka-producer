package com.example.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.producer.messaging.kafka.KafkaMessageProducer;
import com.example.producer.model.Message;


@Configuration
public class KafkaProducerConfig {

	private String kafkaHost = "localhost:9092";
	
	@Bean
	public Map<String, Object> producerConfigs(){
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		//props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		//props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		//props.put(ProducerConfig.LINGER_MS_CONFIG, 10);
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		return props;
	}
	
	@Bean
	public ProducerFactory<String, Message> producerFactory(){
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}
	
	@Bean
	public KafkaTemplate<String, Message> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	
	@Bean
	public KafkaMessageProducer messageProducer() {
		return new KafkaMessageProducer();
	}
}
