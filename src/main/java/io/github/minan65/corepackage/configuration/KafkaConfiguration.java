package io.github.minan65.corepackage.configuration;

import io.github.minan65.corepackage.abstractions.events.IntegrationEvent;
import io.github.minan65.corepackage.abstractions.messaging.transport.EventBusSubscriber;
import io.github.minan65.corepackage.messaging.kafka.consumer.KafkaMessageConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConfiguration {

    @Bean
    public EventBusSubscriber kafkaEventBusSubscriber(DefaultKafkaConsumerFactory<String, IntegrationEvent> consumerFactory) {
        return new KafkaMessageConsumer(consumerFactory);
    }
}