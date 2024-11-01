package com.outbox.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.outbox.entities.Outbox;
import com.outbox.repositories.OutboxRepository;
import io.github.minan65.core_abstractions.events.Event;
import io.github.minan65.core_abstractions.messaging.transport.EventBusProducer;
import io.github.minan65.core_crosscuttingconcerns.extensions.EventFactoryExtension;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OutboxServiceImpl implements OutboxService {

    private final OutboxRepository outboxRepository;
    private final EventBusProducer eventBusProducer;
    private final ObjectMapper objectMapper;


    @Override
    public void saveEvent(Event event, String aggregateId, String aggregateType) throws JsonProcessingException {
        Outbox outbox = new Outbox();
        outbox.setAggregateId(aggregateId);
        outbox.setEventId(event.getEventId());
        outbox.setAggregateType(aggregateType);
        outbox.setEventType(event.getEventType());
        outbox.setPayload(objectMapper.writeValueAsString(event));
        outboxRepository.save(outbox);

    }

    @Scheduled(fixedRate = 5000)
    @Override
    public void processOutbox() throws JsonProcessingException {
        List<Outbox> outboxEntries = outboxRepository.findByProcessedFalse();
        for (Outbox entry : outboxEntries) {
            Event event = EventFactoryExtension.createEvent(entry.getEventType(),entry.getPayload());
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
