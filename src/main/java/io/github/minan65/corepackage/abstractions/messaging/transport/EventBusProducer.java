package io.github.minan65.corepackage.abstractions.messaging.transport;

import io.github.minan65.corepackage.abstractions.events.IntegrationEvent;


public interface EventBusProducer {
    <TEvent extends IntegrationEvent> void produce(TEvent event);
}
