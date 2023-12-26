package com.vermeg.thoughtmachineproducerkafka.model.transactions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Represents an event related to a transaction, including an associated transaction object.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionEvent {
    @Builder.Default
    private String event_id = UUID.randomUUID().toString();
    @Builder.Default
    private String timestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

    private Transaction transaction;

}
