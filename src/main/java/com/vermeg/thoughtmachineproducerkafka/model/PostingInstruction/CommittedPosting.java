package com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a committed posting, including credit, amount, denomination, account ID, account address, asset, and phase.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommittedPosting {

    private String credit;
    private String amount;
    private String denomination;
    private String account_id;
    private String account_address;
    private String asset;
    private String phase="POSTING_PHASE_COMMITTED";
}
