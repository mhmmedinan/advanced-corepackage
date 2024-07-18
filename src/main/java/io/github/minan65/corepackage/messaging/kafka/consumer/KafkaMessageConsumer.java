package io.github.minan65.corepackage.messaging.kafka.consumer;

import io.github.minan65.corepackage.abstractions.events.IntegrationEvent;
import io.github.minan65.corepackage.abstractions.messaging.transport.EventBusConsumer;
import io.github.minan65.corepackage.abstractions.messaging.transport.EventBusSubscriber;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaMessageConsumer implements EventBusSubscriber {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageConsumer.class);
    private final DefaultKafkaConsumerFactory<String, IntegrationEvent> consumerFactory;

    public KafkaMessageConsumer(DefaultKafkaConsumerFactory<String, IntegrationEvent> consumerFactory) {
        this.consumerFactory = consumerFactory;
    }

    @Override
    public <TEvent extends IntegrationEvent> void subscribe(TEvent event, EventBusConsumer<TEvent> consumer) {
        Map<String, Object> consumerProps = new HashMap<>(consumerFactory.getConfigurationProperties());
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, event.getGroupId());
        KafkaConsumer<String, IntegrationEvent> kafkaConsumer = new KafkaConsumer<>(consumerProps);
        kafkaConsumer.subscribe(Collections.singletonList(event.getTopicName()));
        new Thread(() -> {
            while (true) {
                kafkaConsumer.poll(Duration.ofMillis(100)).forEach(record -> {
                    LOGGER.info("Consumed event: {}", record.value());
                    consumer.consume((TEvent) record.value());
                });
            }
        }).start();
    }
}


