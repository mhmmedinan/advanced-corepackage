package com.outbox.configuration;

import io.github.minan65.core_abstractions.events.Event;
import io.github.minan65.core_abstractions.messaging.transport.EventBusProducer;
import io.github.minan65.core_messaging_transport_kafka.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public EventBusProducer kafkaProducer(KafkaTemplate<String, Event> kafkaTemplate) {
        return new KafkaProducer(kafkaTemplate);
    }
}
