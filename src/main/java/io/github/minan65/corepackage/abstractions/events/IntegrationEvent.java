package io.github.minan65.corepackage.abstractions.events;

public abstract class IntegrationEvent extends Event {

    private String correlationId;

    public String getCorrelationId() {
        return correlationId;
    }

    protected void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

}
