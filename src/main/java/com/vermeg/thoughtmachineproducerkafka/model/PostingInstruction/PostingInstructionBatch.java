package com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Represents a batch of posting instructions, including an ID, client ID, list of posting instructions, and status.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostingInstructionBatch {

    private String id = UUID.randomUUID().toString();
    private String client_id;
    private List<PostingInstruction> posting_instructions;
    private String status;

}
