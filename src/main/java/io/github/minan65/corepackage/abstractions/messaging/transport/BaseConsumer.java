package io.github.minan65.corepackage.abstractions.messaging.transport;

import io.github.minan65.corepackage.abstractions.events.Event;

public abstract class BaseConsumer<TEvent extends Event> implements EventBusConsumer<TEvent>  {

    private final EventBusSubscriber eventBusSubscriber;
    private final Class<? extends TEvent> classType;

    public BaseConsumer(EventBusSubscriber eventBusSubscriber, Class<? extends TEvent> classType) {
        this.eventBusSubscriber = eventBusSubscriber;
        this.classType = classType;
    }

    public void startConsuming() throws Exception {
        TEvent event = classType.getConstructor().newInstance();
        this.eventBusSubscriber.subscribe(event, this);
    }
}
