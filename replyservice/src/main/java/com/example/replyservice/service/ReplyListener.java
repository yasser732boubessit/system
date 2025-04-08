package com.example.replyservice.service;

import com.example.replyservice.model.Item;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReplyListener {

    @KafkaListener(topics = "items-topic", groupId = "reply-service-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Item item) {
        System.out.println(" Received item via Kafka:");
    //    System.out.println(" Item ID: " + item.getItemID());
        System.out.println(" Categories: " + item.getCategories());
    }
}
