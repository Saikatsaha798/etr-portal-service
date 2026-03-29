package com.etr.portal.kafka;

import com.etr.common.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * The type Kafka config.
 */
@Configuration
@EnableKafka
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaConfig {
}
