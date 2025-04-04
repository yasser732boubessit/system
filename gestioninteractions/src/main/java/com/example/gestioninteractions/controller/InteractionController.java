package com.example.gestioninteractions.controller;

import com.example.gestioninteractions.service.InteractionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {
    
    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        interactionService.sendMessage(message);
        return "Message envoyé à ReplyService : " + message;
    }
}
