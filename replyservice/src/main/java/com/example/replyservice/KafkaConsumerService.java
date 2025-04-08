package com.example.replyservice;

import com.example.replyservice.model.Item;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Service;

import java.util.List;

@EnableKafka
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${kafka.topic.items}", groupId = "reply-service-group")
    public void listen(List<Item> items) {
        System.out.println("🔴 Received items: " + items.size());
        for (Item item : items) {
            System.out.println("Item: " + item.getCategories());
        }
    }
}
