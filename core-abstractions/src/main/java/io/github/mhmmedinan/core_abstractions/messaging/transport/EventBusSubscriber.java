package io.github.mhmmedinan.core_abstractions.messaging.transport;

import io.github.mhmmedinan.core_abstractions.events.Event;

public interface EventBusSubscriber {
    <TEvent extends Event> void subscribe(TEvent event, EventBusConsumer<TEvent> consumer);
}
