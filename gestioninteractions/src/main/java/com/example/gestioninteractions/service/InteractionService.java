package com.example.gestioninteractions.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class InteractionService {
    
    private final RabbitTemplate rabbitTemplate;
    private final String exchange = "replyExchange";
    private final String routingKey = "replyKey";

    public InteractionService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 10000)  // Envoie un message toutes les 10 secondes
    public void sendMessage() {
        String message = "Hello ReplyService, message envoyé à " + System.currentTimeMillis();
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Message envoyé : " + message);
    }
}
