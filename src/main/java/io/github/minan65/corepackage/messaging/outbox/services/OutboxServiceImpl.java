package io.github.minan65.corepackage.messaging.outbox.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.minan65.corepackage.abstractions.events.Event;
import io.github.minan65.corepackage.abstractions.messaging.transport.EventBusProducer;
import io.github.minan65.corepackage.messaging.outbox.Outbox;
import io.github.minan65.corepackage.messaging.outbox.repositories.OutboxRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class OutboxServiceImpl implements OutboxService {

    private final OutboxRepository outboxRepository;
    private final EventBusProducer eventBusProducer;
    private ObjectMapper objectMapper;

    public OutboxServiceImpl(OutboxRepository outboxRepository, EventBusProducer eventBusProducer) {
        this.outboxRepository = outboxRepository;
        this.eventBusProducer = eventBusProducer;
    }


    @Override
    public void saveEvent(Event event, String aggregateId, String aggregateType) throws JsonProcessingException {
        Outbox outbox = new Outbox();
        outbox.setAggregateId(aggregateId);
        outbox.setEventId(event.getEventId());
        outbox.setAggregateType(aggregateType);
        outbox.setEventType(event.getEventType());
        outbox.setOccurredOn(event.getOccurredOn());
        outbox.setPayload(objectMapper.writeValueAsString(event));
        outboxRepository.save(outbox);
    }

    @Scheduled(fixedRate = 5000)
    @Override
    public void processOutbox() throws JsonProcessingException {
        List<Outbox> outboxEntries = outboxRepository.findByProcessedFalse();
        for (Outbox entry : outboxEntries) {
            // Event payload'ı artık doğrudan eventBusProducer ile gönderilecek
            Event event = objectMapper.readValue(entry.getPayload(), Event.class);
            eventBusProducer.produce(event);
            entry.setProcessed(true);
            outboxRepository.save(entry);
        }
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void cleanupOutbox() {
        outboxRepository.deleteByProcessedTrueAndOccurredOnBefore(OffsetDateTime.now().minusDays(1));
    }
}
