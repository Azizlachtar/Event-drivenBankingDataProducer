package com.vermeg.thoughtmachineproducerkafka.services;

import com.vermeg.thoughtmachineproducerkafka.model.customers.EventCustomer;
import com.vermeg.thoughtmachineproducerkafka.model.transactions.TransactionEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
/**
 * Service for producing transaction-related Kafka events.
 */
@Service
@RequiredArgsConstructor
public class TransactionProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProducerService.class);

    private final NewTopic createTransactionTopic;

    private final KafkaTemplate<String, EventCustomer> kafkaTemplate;


    /**
     * Sends a create transaction event to the Kafka topic.
     *
     * @param event The transaction event to be sent.
     */
    public void sendCreateTransactionEvent(TransactionEvent event) {
        LOGGER.info(String.format("Transaction message => %s", event.toString()));
        LOGGER.info(String.format("Transaction Topic => %s", createTransactionTopic.name()));


        Message<TransactionEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, createTransactionTopic.name())
                .build();

        kafkaTemplate.send(message);

    }


}


