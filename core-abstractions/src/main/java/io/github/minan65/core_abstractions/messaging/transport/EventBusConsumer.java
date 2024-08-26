package io.github.minan65.core_abstractions.messaging.transport;


import io.github.minan65.core_abstractions.events.Event;

public interface EventBusConsumer<TEvent extends Event>
{
     void consume(TEvent event);

}
