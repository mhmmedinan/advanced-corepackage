package io.github.minan65.corepackage.abstractions.messaging.transport;

import io.github.minan65.corepackage.abstractions.events.Event;


public interface EventBusProducer {
    <TEvent extends Event> void produce(TEvent event);
}
