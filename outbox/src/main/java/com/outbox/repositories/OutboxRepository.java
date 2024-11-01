package com.outbox.repositories;

import com.outbox.entities.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface OutboxRepository extends JpaRepository<Outbox, UUID> {
    List<Outbox> findByProcessedFalse();
    void deleteByProcessedTrueAndOccurredOnBefore(OffsetDateTime timestamp);
}