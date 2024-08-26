package io.github.minan65.core_crosscuttingconcerns.extensions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.minan65.core_abstractions.events.Event;
import io.github.minan65.core_abstractions.types.EventType;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EventFactoryExtension {
    private static final Map<String, Class<? extends Event>> EVENT_TYPES = new HashMap<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        Reflections reflections = new Reflections("com.common.events"); // Paket ismini kendi projenize göre ayarlayın
        Set<Class<? extends Event>> eventClasses = reflections.getSubTypesOf(Event.class);

        for (Class<? extends Event> eventClass : eventClasses) {
            EventType annotation = eventClass.getAnnotation(EventType.class);
            if (annotation != null) {
                EVENT_TYPES.put(annotation.value(), eventClass);
            }
        }
    }

    public static Event createEvent(String eventType, String jsonPayload) throws JsonProcessingException {
        Class<? extends Event> eventClass = EVENT_TYPES.get(eventType);
        if (eventClass == null) {
            throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
        return objectMapper.readValue(jsonPayload, eventClass);
    }

}
