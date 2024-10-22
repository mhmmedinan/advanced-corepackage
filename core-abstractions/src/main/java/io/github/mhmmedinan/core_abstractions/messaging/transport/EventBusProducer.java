package io.github.mhmmedinan.core_abstractions.messaging.transport;


import io.github.mhmmedinan.core_abstractions.events.Event;

public interface EventBusProducer {
    <TEvent extends Event> void produce(TEvent event);
}
