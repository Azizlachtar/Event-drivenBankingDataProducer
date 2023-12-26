    package com.vermeg.thoughtmachineproducerkafka.services;

    import com.vermeg.thoughtmachineproducerkafka.model.accounts.AccountEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.created.AccountCreatedEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.updated.AccountUpdatedEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.customers.EventCustomer;
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
     * Service for producing account-related Kafka events.
     */
    @Service
    @RequiredArgsConstructor
    public class AccountProducerService {

        private static final Logger LOGGER= LoggerFactory.getLogger(AccountProducerService.class);

        private final NewTopic createAccountTopic;
        private final NewTopic updateAccountTopic;

        private final KafkaTemplate<String, EventCustomer> kafkaTemplate;


        /**
         * Sends a create account event to the Kafka topic.
         *
         * @param event The account creation event to be sent.
         */

        public void sendCreateAccountEvent2(AccountEvent<AccountCreatedEvent> event){
            LOGGER.info(String.format("Account message => %s",event.toString()));
            LOGGER.info(String.format("Account Topic => %s",createAccountTopic.name()));

            Message<AccountEvent<AccountCreatedEvent>> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, createAccountTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }

        /**
         * Sends an update account event to the Kafka topic.
         *
         * @param event The account update event to be sent.
         */
        public void sendUpdateAccountEvent2(AccountEvent<AccountUpdatedEvent> event){
            LOGGER.info(String.format("Account message => %s",event.toString()));
            LOGGER.info(String.format("Account Topic => %s",updateAccountTopic.name()));

            Message<AccountEvent<AccountUpdatedEvent>> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, updateAccountTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }


    }


