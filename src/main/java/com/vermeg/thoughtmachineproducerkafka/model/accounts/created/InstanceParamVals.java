package com.vermeg.thoughtmachineproducerkafka.model.accounts.created;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a creation to the instance parameters of an account.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstanceParamVals {
    private String arranged_overdraft_limit;
    private String autosave_savings_account;
    private String daily_atm_withdrawal_limit;
    private String interest_application_day;
    private String unarranged_overdraft_limit;
    // Add other fields as needed
}
