package io.github.minan65.corepackage.abstractions.messaging.transport;

import io.github.minan65.corepackage.abstractions.events.IntegrationEvent;

public interface EventBusSubscriber {
    <TEvent extends IntegrationEvent> void subscribe(TEvent event, EventBusConsumer<TEvent> consumer);
}
