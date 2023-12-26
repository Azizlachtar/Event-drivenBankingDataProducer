package com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Represents a posting instruction, including an ID, client transaction ID, and list of committed postings.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostingInstruction {

    private String id= UUID.randomUUID().toString();
    private String client_transaction_id=UUID.randomUUID().toString();

    private List<CommittedPosting> committed_postings;

}
