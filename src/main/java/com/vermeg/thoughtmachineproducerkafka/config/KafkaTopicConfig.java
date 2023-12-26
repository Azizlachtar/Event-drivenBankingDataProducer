package com.vermeg.thoughtmachineproducerkafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for Kafka topics and the KafkaAdmin instance.
 */

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapAddress;

    /**
     * Creates a KafkaAdmin bean for managing Kafka topics.
     *
     * @return The KafkaAdmin instance.
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    /**
     * Creates a NewTopic bean for creating a customer topic.
     *
     * @param topicName         The name of the customer topic.
     * @param partitions        The number of partitions for the topic.
     * @param replicationFactor The replication factor for the topic.
     * @return NewTopic instance for the customer topic.
     */
    @Bean
    public NewTopic createCustomerTopic(@Value("${spring.kafka.topic-create-customer}") String topicName,
                                        @Value("${spring.kafka.topic-partitions}") int partitions,
                                        @Value("${spring.kafka.topic-replication-factor}") short replicationFactor) {
        return new NewTopic(topicName, partitions, replicationFactor);
    }

    /**
     * Creates a NewTopic bean for updating a customer topic.
     *
     * @param topicName         The name of the customer topic.
     * @param partitions        The number of partitions for the topic.
     * @param replicationFactor The replication factor for the topic.
     * @return NewTopic instance for the customer topic.
     */
    @Bean
    public NewTopic updateCustomerTopic(@Value("${spring.kafka.topic-update-customer}") String topicName,
                                        @Value("${spring.kafka.topic-partitions}") int partitions,
                                        @Value("${spring.kafka.topic-replication-factor}") short replicationFactor) {
        return new NewTopic(topicName, partitions, replicationFactor);
    }

    /**
     * Creates a NewTopic bean for creating a account topic.
     *
     * @param topicName         The name of the customer topic.
     * @param partitions        The number of partitions for the topic.
     * @param replicationFactor The replication factor for the topic.
     * @return NewTopic instance for the customer topic.
     */
    @Bean
    public NewTopic createAccountTopic(@Value("${spring.kafka.topic-create-account}") String topicName,
                                        @Value("${spring.kafka.topic-partitions}") int partitions,
                                        @Value("${spring.kafka.topic-replication-factor}") short replicationFactor) {
        return new NewTopic(topicName, partitions, replicationFactor);
    }
    /**
     * Creates a NewTopic bean for updating an account topic.
     *
     * @param topicName         The name of the customer topic.
     * @param partitions        The number of partitions for the topic.
     * @param replicationFactor The replication factor for the topic.
     * @return NewTopic instance for the customer topic.
     */
    @Bean
    public NewTopic updateAccountTopic(@Value("${spring.kafka.topic-update-account}") String topicName,
                                       @Value("${spring.kafka.topic-partitions}") int partitions,
                                       @Value("${spring.kafka.topic-replication-factor}") short replicationFactor) {
        return new NewTopic(topicName, partitions, replicationFactor);
    }

    /**
     * Creates a NewTopic bean for creating a balance topic.
     *
     * @param topicName         The name of the customer topic.
     * @param partitions        The number of partitions for the topic.
     * @param replicationFactor The replication factor for the topic.
     * @return NewTopic instance for the customer topic.
     */
    @Bean
    public NewTopic createBalanceTopic(@Value("${spring.kafka.topic-create-balance}") String topicName,
                                       @Value("${spring.kafka.topic-partitions}") int partitions,
                                       @Value("${spring.kafka.topic-replication-factor}") short replicationFactor) {
        return new NewTopic(topicName, partitions, replicationFactor);
    }
    /**
     * Creates a NewTopic bean for creating a transaction topic.
     *
     * @param topicName         The name of the customer topic.
     * @param partitions        The number of partitions for the topic.
     * @param replicationFactor The replication factor for the topic.
     * @return NewTopic instance for the customer topic.
     */


    @Bean
    public NewTopic createTransactionTopic(@Value("${spring.kafka.topic-create-transaction}") String topicName,
                                       @Value("${spring.kafka.topic-partitions}") int partitions,
                                       @Value("${spring.kafka.topic-replication-factor}") short replicationFactor) {
        return new NewTopic(topicName, partitions, replicationFactor);
    }

    /**
     * Creates a NewTopic bean for creating a PostingInstructionBatch topic.
     *
     * @param topicName         The name of the customer topic.
     * @param partitions        The number of partitions for the topic.
     * @param replicationFactor The replication factor for the topic.
     * @return NewTopic instance for the customer topic.
     */
    @Bean
    public NewTopic createPostingInstructionBatchTopic(@Value("${spring.kafka.topic-create-PostingInstructionBatch}") String topicName,
                                           @Value("${spring.kafka.topic-partitions}") int partitions,
                                           @Value("${spring.kafka.topic-replication-factor}") short replicationFactor) {
        return new NewTopic(topicName, partitions, replicationFactor);
    }


}
