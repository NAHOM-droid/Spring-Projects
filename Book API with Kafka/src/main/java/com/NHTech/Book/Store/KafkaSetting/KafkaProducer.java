package com.NHTech.Book.Store.KafkaSetting;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendBookMessage(KafkaBook book) {
        Message<KafkaBook> message = MessageBuilder
                .withPayload(book)
                .setHeader(KafkaHeaders.TOPIC, "Topic.Book")
                .build();
        kafkaTemplate.send(message);
        log.info(String.format("Message Sent -> %s", book));
    }
}
