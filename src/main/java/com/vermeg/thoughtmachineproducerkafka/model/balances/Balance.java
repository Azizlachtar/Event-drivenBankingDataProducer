package com.vermeg.thoughtmachineproducerkafka.model.balances;

import com.vermeg.thoughtmachineproducerkafka.model.customers.CustomerDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;


/**
 * Represents a balance associated with an account, including ID, account ID, asset, amount, and denomination.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Balance {

    private String id= UUID.randomUUID().toString();
    private String account_id;
    private String asset;
    private BigDecimal amount;
    private String denomination;

}
