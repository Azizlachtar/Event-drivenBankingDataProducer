package com.vermeg.thoughtmachineproducerkafka.model.accounts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Represents an event related to an account, which can be either an account creation or update event.
 *
 * @param <T> The type of account event data.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountEvent<T> {
    @Builder.Default
    private String event_id = UUID.randomUUID().toString();
    @Builder.Default
    private String timestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

    private T account_created;
    private T account_update_updated;

}
