package io.github.minan65.corepackage.abstractions.events;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;


public abstract class Event {
    private final UUID eventId = UUID.randomUUID();
    private long eventVersion = -1;
    private final OffsetDateTime occurredOn = OffsetDateTime.now();
    private final OffsetDateTime timeStamp = OffsetDateTime.now();

    public UUID getEventId() {
        return eventId;
    }

    public long getEventVersion() {
        return eventVersion;
    }

    protected void setEventVersion(long eventVersion) {
        this.eventVersion = eventVersion;
    }

    public OffsetDateTime getOccurredOn() {
        return occurredOn;
    }

    public OffsetDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getEventType() {
        return getClass().getName();
    }

    public abstract String getTopicName();
    public abstract String getGroupId();


}
