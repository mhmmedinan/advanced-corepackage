package io.github.minan65.corepackage.abstractions.events;

import java.util.UUID;

public abstract class IntegrationEvent extends Event {

    private UUID correlationId;

    public IntegrationEvent(){
        this.correlationId=UUID.randomUUID();
    }

    public UUID getCorrelationId() {
        return correlationId;
    }

    protected void setCorrelationId(UUID correlationId) {
        this.correlationId = correlationId;
    }

}
