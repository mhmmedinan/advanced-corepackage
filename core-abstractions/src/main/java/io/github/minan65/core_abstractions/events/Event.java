package io.github.minan65.core_abstractions.events;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;


public class Event {
    private final UUID eventId;
    private long eventVersion;
    private String topicName;

    public Event(){
        this.eventId=UUID.randomUUID();
        this.eventVersion=-1;
    }

    public UUID getEventId() {
        return eventId;
    }

    public long getEventVersion() {
        return eventVersion;
    }

    protected void setEventVersion(long eventVersion) {
        this.eventVersion = eventVersion;
    }


    @JsonIgnore
    public String getEventType() {
        return getClass().getSimpleName();
    }


    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
