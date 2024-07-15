package io.github.minan65.corepackage.messaging.kafka.consumer;

import io.github.minan65.corepackage.abstractions.events.EventHandler;
import io.github.minan65.corepackage.abstractions.events.IntegrationEvent;
import io.github.minan65.corepackage.abstractions.messaging.transport.EventBusConsumer;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer<TEvent extends IntegrationEvent> implements EventBusConsumer<TEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private EventHandler<IntegrationEvent> eventHandler;

    @KafkaListener(
            topics = "#{T(io.github.minan65.corepackage.abstractions.events.Event).topicName()}",
            groupId = "#{T(io.github.minan65.corepackage.abstractions.events.Event).groupId()}"
    )
    public  <TEvent extends IntegrationEvent> void consume(TEvent event) {

        LOGGER.info(String.format("%s received => %s", event.getClass().getSimpleName(), event.toString()));

        eventHandler.handle(event);
    }
    }
