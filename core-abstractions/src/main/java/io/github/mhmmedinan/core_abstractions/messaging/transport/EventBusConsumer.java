package io.github.mhmmedinan.core_abstractions.messaging.transport;


import io.github.mhmmedinan.core_abstractions.events.Event;

public interface EventBusConsumer<TEvent extends Event>
{
     void consume(TEvent event);

}
