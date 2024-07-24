package io.github.minan65.corepackage.abstractions.messaging.transport;

import io.github.minan65.corepackage.abstractions.events.Event;


public interface EventBusConsumer<TEvent extends Event>
{
     void consume(TEvent event);

}
