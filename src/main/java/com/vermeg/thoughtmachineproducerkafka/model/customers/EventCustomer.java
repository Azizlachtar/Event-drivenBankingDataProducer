package com.vermeg.thoughtmachineproducerkafka.model.customers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an event related to a customer, including customer data and technical metadata.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventCustomer {
    private Customer customer;
    private String technical_metadata;
    private String eventId;


}
