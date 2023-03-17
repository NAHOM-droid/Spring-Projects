package com.NHTech.Book.Store.KafkaSetting;

import com.NHTech.Book.Store.BookApplication.BookAPI.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log= LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "FirstTopic", groupId = "myGroup")
    public void consume(String msg){
        log.info(String.format("Message received --> %s", msg));
    }

    @KafkaListener(topics = "Topic.Book", groupId = "myGroup")
    public void consumeJson(KafkaBook book){
        log.info(String.format("Book info received --> %s", book));
    }
}
