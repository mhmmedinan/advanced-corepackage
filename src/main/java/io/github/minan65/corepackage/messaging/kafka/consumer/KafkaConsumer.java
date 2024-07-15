package io.github.minan65.corepackage.messaging.kafka.consumer;

import io.github.minan65.corepackage.abstractions.events.EventHandler;
import io.github.minan65.corepackage.abstractions.events.IntegrationEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer<TEvent extends IntegrationEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private EventHandler<TEvent> eventHandler;

    @KafkaListener(topics = "#{@eventLs}", groupId = "#{@eventGroupId}")
    public void consume(TEvent event) {

        LOGGER.info(String.format("%s received => %s", event.getClass().getSimpleName(), event.toString()));

        eventHandler.handle(event);
    }
}
