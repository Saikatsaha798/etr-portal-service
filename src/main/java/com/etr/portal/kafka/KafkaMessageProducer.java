package com.etr.portal.kafka;

import com.etr.model.MessageObject;
import com.etr.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessageProducer implements KafkaProducer<MessageObject> {

    private final KafkaTemplate<String, MessageObject> kafkaTemplate;
    private static final Logger log = LoggerFactory.getLogger(KafkaMessageProducer.class);

    @Override
    public void publish(String topic, String key, MessageObject message) {
        kafkaTemplate.send(topic, key, message);
    }
}
