package com.anderson.kafka.series.application.controller.taxpayer;

import com.anderson.kafka.series.infra.messaging.config.KafkaProperties;
import com.anderson.kafka.series.infra.messaging.config.MessagingConfigPort;
import com.irs.register.avro.taxpayer.TaxPayer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;


@Configuration
public class MessagingConfigTaxPayer implements MessagingConfigPort<TaxPayer> {
	
	@Autowired
	private KafkaProperties kafkaProperties;

	@Bean(name = "taxpayerProducer")
	@Override
	public KafkaProducer<String, TaxPayer> configureProducer() {

		Properties properties = new Properties();
		
        properties.put(BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(ACKS_CONFIG, kafkaProperties.getAcksConfig());
        properties.put(RETRIES_CONFIG, kafkaProperties.getRetriesConfig());
        properties.put(KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getKeySerializer());
        properties.put(VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getValueSerializer());
        properties.put(SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getSchemaRegistryUrl());
		
		return new KafkaProducer<String, TaxPayer>(properties);
		
	}

}
