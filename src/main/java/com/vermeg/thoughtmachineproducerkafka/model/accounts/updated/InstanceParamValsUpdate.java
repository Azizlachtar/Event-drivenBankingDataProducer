package com.vermeg.thoughtmachineproducerkafka.model.accounts.updated;


import com.vermeg.thoughtmachineproducerkafka.model.accounts.created.InstanceParamVals;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Represents an update to the instance parameters of an account.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstanceParamValsUpdate {
    private InstanceParamVals instance_param_vals;
}
