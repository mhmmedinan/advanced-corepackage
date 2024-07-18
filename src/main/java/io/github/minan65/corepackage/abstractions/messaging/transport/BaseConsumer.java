package io.github.minan65.corepackage.abstractions.messaging.transport;

import io.github.minan65.corepackage.abstractions.events.IntegrationEvent;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseConsumer<TEvent extends IntegrationEvent> implements EventBusConsumer<TEvent>  {

    private final EventBusSubscriber eventBusSubscriber;
    private final Class<? extends TEvent> classType;

    public BaseConsumer(EventBusSubscriber eventBusSubscriber, Class<? extends TEvent> classType) {
        this.eventBusSubscriber = eventBusSubscriber;
        this.classType = classType;
    }

    public void startConsuming() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        TEvent event = classType.getConstructor().newInstance();
        this.eventBusSubscriber.subscribe(event, this);
    }
}
