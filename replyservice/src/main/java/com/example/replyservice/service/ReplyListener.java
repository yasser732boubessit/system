package com.example.replyservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReplyListener {

    @RabbitListener(queues = "replyQueue")
    public void receiveMessage(String message) {
        System.out.println("Réponse reçue de GestionInteractionsService : " + message);
    }
}
