package com.common.events.customers;


import io.github.minan65.core_abstractions.events.IntegrationEvent;
import io.github.minan65.core_abstractions.types.EventType;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EventType("IndividualCustomerDeleteEvent")
public class IndividualCustomerDeleteEvent extends IntegrationEvent {

    private String id;
    private LocalDateTime deletedDate;

    @Override
    public String getTopicName() {
        return "deleted-customer";
    }
}
