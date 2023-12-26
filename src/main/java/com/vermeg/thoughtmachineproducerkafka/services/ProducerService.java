/*
    package com.vermeg.thoughtmachineproducerkafka.services;

    import com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction.EventPostingInstruction;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.created.AccountCreatedEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.updated.AccountUpdatedEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.balances.AccountBalanceEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.customers.EventCustomer;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.AccountEvent;
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

    @Service
    @RequiredArgsConstructor
    public class ProducerService {

        private static final Logger LOGGER= LoggerFactory.getLogger(ProducerService.class);

        private final NewTopic createCustomerTopic;
        private final NewTopic updateCustomerTopic;
        private final NewTopic createAccountTopic;
        private final NewTopic updateAccountTopic;
        private final NewTopic createBalanceTopic;
        private final NewTopic createTransactionTopic;
        private final NewTopic createPostingInstructionBatchTopic;

        private final KafkaTemplate<String, EventCustomer> kafkaTemplate;


        public void sendCreateCustomerEvent(EventCustomer event){
            LOGGER.info(String.format("Customer message => %s",event.toString()));
            LOGGER.info(String.format("Customer Topic => %s",createCustomerTopic.name()));


            Message<EventCustomer> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, createCustomerTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }

        public void sendUpdateCustomerEvent(EventCustomer event){
            LOGGER.info(String.format("Customer message => %s",event.toString()));
            LOGGER.info(String.format("Customer Topic => %s",updateCustomerTopic.name()));

            Message<EventCustomer> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, updateCustomerTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }


        public void sendCreateAccountEvent2(AccountEvent<AccountCreatedEvent> event){
            LOGGER.info(String.format("Account message => %s",event.toString()));
            LOGGER.info(String.format("Account Topic => %s",createAccountTopic.name()));

            Message<AccountEvent<AccountCreatedEvent>> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, createAccountTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }

        public void sendUpdateAccountEvent2(AccountEvent<AccountUpdatedEvent> event){
            LOGGER.info(String.format("Account message => %s",event.toString()));
            LOGGER.info(String.format("Account Topic => %s",updateAccountTopic.name()));

            Message<AccountEvent<AccountUpdatedEvent>> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, updateAccountTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }

        public void sendCreateBalanceEvent(AccountBalanceEvent event){
            LOGGER.info(String.format("Balance message => %s",event.toString()));
            LOGGER.info(String.format("Balance Topic => %s",createBalanceTopic.name()));


            Message<AccountBalanceEvent> message= MessageBuilder
                    .withPayload(event)
                    .setHeader(KafkaHeaders.TOPIC, createBalanceTopic.name())
                    .build();

            kafkaTemplate.send(message);

        }

        public void sendCreateTransactionEvent(TransactionEvent event){
            LOGGER.info(String.format("Transaction message => %s",event.toString()));
            LOGGER.info(String.format("Transaction Topic => %s",createTransactionTopic.name()));


            Message<TransactionEvent> message= MessageBuilder
                    .withPayload(event)
                    .setHeader(KafkaHeaders.TOPIC, createTransactionTopic.name())
                    .build();

            kafkaTemplate.send(message);

        }

        public void sendCreatePostingInstructionBatchEvent(EventPostingInstruction event){
            LOGGER.info(String.format("PostingInstructionBatch message => %s",event.toString()));
            LOGGER.info(String.format("PostingInstructionBatch Topic => %s",createPostingInstructionBatchTopic.name()));


            Message<EventPostingInstruction> message= MessageBuilder
                    .withPayload(event)
                    .setHeader(KafkaHeaders.TOPIC, createPostingInstructionBatchTopic.name())
                    .build();

            kafkaTemplate.send(message);

        }





*/
/* public void sendCreateAccountEvent(EventAccountCreate event){
            LOGGER.info(String.format("Order message => %s",event.toString()));
            LOGGER.info(String.format("Order message => %s",createAccountTopic.name()));

            Message<EventAccountCreate> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, createAccountTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }
        public void sendUpdateAccountEvent(EventAccountUpdate event){
            LOGGER.info(String.format("Order message => %s",event.toString()));
            LOGGER.info(String.format("Order message => %s",updateAccountTopic.name()));

            Message<EventAccountUpdate> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, updateAccountTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }*//*




    }


*/
