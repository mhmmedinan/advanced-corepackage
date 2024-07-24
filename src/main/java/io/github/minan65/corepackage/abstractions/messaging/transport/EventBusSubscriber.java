package io.github.minan65.corepackage.abstractions.messaging.transport;

import io.github.minan65.corepackage.abstractions.events.Event;

public interface EventBusSubscriber {
    <TEvent extends Event> void subscribe(TEvent event, EventBusConsumer<TEvent> consumer);
}
