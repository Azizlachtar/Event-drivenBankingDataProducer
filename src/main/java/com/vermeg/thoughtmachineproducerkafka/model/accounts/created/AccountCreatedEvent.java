package com.vermeg.thoughtmachineproducerkafka.model.accounts.created;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Represents an event for the creation of an account.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountCreatedEvent {
    private Account account;
}
