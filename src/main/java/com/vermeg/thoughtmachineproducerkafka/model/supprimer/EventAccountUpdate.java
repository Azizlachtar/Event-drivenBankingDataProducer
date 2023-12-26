/*
package com.vermeg.thoughtmachineproducerkafka.model.supprimer;


import com.vermeg.thoughtmachineproducerkafka.model.accounts.updated.AccountUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventAccountUpdate {
    @Builder.Default
    private String event_id= UUID.randomUUID().toString();
    @Builder.Default
    private String timestamp= DateTimeFormatter.ISO_INSTANT.format(Instant.now());
    private AccountUpdatedEvent account_update_updated;

}
*/
