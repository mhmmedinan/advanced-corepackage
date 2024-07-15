package io.github.minan65.corepackage.messaging.kafka.producer;


import io.github.minan65.corepackage.abstractions.events.IntegrationEvent;
import io.github.minan65.corepackage.abstractions.messaging.transport.EventBusProducer;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.messaging.support.MessageBuilder;

@Service
@AllArgsConstructor
public class KafkaProducer implements EventBusProducer {

    private final KafkaTemplate<String,IntegrationEvent> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Override
    public <TEvent extends IntegrationEvent> void produce(TEvent event) {
        LOGGER.info(String.format("%s created => %s", event.getClass().getSimpleName(), event.toString()));
        Message<TEvent> message = MessageBuilder.withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,event.topicName())
                        .build();
        kafkaTemplate.send(message);
    }
}
