package com.outbox.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.minan65.core_abstractions.events.Event;

public interface OutboxService {
    public void saveEvent(Event event, String aggregateId, String aggregateType) throws JsonProcessingException;
    public void processOutbox() throws JsonProcessingException;
    public void cleanupOutbox();

}
