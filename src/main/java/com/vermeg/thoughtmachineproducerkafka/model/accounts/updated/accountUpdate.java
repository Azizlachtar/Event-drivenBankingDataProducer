package com.vermeg.thoughtmachineproducerkafka.model.accounts.updated;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.format.DateTimeFormatter;


/**
 * Represents an account update with its associated details.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class accountUpdate {

    private String account_id;
    private String status = "ACCOUNT_UPDATE_STATUS_COMPLETED";
    private InstanceParamValsUpdate instance_param_vals_update;
    private String create_timestamp= DateTimeFormatter.ISO_INSTANT.format(Instant.now());

}
