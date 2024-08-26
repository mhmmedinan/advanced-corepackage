package io.github.minan65.core_abstractions.messaging.transport;


import io.github.minan65.core_abstractions.events.Event;

public interface EventBusProducer {
    <TEvent extends Event> void produce(TEvent event);
}
