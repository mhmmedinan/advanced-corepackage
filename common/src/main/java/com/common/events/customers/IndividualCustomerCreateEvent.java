package com.common.events.customers;


import io.github.minan65.core_abstractions.events.IntegrationEvent;
import io.github.minan65.core_abstractions.types.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EventType("IndividualCustomerCreateEvent")
public class IndividualCustomerCreateEvent extends IntegrationEvent {

    private String id;
    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    private String motherName;

    private String fatherName;

    private String nationalityIdentity;

    @Override
    public String getTopicName() {
        return "created-customer";
    }

}
