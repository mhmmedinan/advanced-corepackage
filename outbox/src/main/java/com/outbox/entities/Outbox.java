package com.outbox.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "outbox")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Outbox {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID eventId;

    @Column(nullable = false)
    private String aggregateId;

    @Column(nullable = false)
    private String aggregateType;

    @Column(nullable = false)
    private String eventType;

    @Column(nullable = false,length = 2000)
    private String payload;

    @Column(nullable = true)
    private OffsetDateTime occurredOn;

    @Column(nullable = false)
    private boolean processed = false;
}