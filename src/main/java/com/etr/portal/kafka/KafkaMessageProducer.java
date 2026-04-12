package com.etr.portal.kafka;

import com.etr.common.KafkaProperties;
import com.etr.model.MessageObject;
import com.etr.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Kafka message producer.
 */
@Service
@RequiredArgsConstructor
public class KafkaMessageProducer implements KafkaProducer<MessageObject> {

    private final KafkaTemplate<String, MessageObject> kafkaTemplate;
    private static final Logger log = LoggerFactory.getLogger(KafkaMessageProducer.class);
    private final KafkaProperties kafkaProperties;

    @Override
    public void publish(String topic, String key, MessageObject message) {
        log.info("Sending message to topic={} with key={}", topic, key);
        kafkaTemplate.send(topic, key, message);
    }

    /**
     * Send message.
     *
     * @param messageObject the message object
     */
    public void publishMessage(MessageObject messageObject) {
        publish(kafkaProperties.getMessageConversation(), messageObject.getMessageId(), messageObject);
    }
}
