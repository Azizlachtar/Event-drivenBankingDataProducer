package com.vermeg.thoughtmachineproducerkafka.model.accounts.updated;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an event for the update of an account.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountUpdatedEvent {

    private accountUpdate account_update;

}
