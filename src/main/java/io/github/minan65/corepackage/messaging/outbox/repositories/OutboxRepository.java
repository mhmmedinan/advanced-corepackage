package io.github.minan65.corepackage.messaging.outbox.repositories;

import io.github.minan65.corepackage.messaging.outbox.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.*;

@Repository
public interface OutboxRepository extends JpaRepository<Outbox, UUID> {
    List<Outbox> findByProcessedFalse();
    void deleteByProcessedTrueAndOccurredOnBefore(OffsetDateTime timestamp);
}
