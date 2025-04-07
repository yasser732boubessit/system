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

    // Appelée automatiquement toutes les 10 secondes
    @Scheduled(fixedRate = 10000)
    public void sendMessage() {
        String autoMessage = "Auto-message à " + System.currentTimeMillis();
        rabbitTemplate.convertAndSend(exchange, routingKey, autoMessage);
        System.out.println("Message automatique envoyé : " + autoMessage);
    }

    // Appelée manuellement via HTTP avec un message personnalisé
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Message manuel envoyé : " + message);
    }
}
