package com.vermeg.thoughtmachineproducerkafka.model.accounts.created;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an account with its associated details.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private String id= UUID.randomUUID().toString();
    private String name;
    private List<String> permitted_denominations;
    private String status = "ACCOUNT_STATUS_OPEN";
    private String opening_timestamp= DateTimeFormatter.ISO_INSTANT.format(Instant.now());
    private List<String> stakeholder_ids;
    private InstanceParamVals instance_param_vals;

}
