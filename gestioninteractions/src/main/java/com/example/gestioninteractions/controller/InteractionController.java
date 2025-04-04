package com.example.gestioninteractions.controller;

import com.example.gestioninteractions.model.Interaction;
import com.example.gestioninteractions.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    @GetMapping
    public List<Interaction> getAllInteractions() {
        return interactionService.getAllInteractions();
    }

    @PostMapping
    public Interaction createInteraction(@RequestBody Interaction interaction) {
        return interactionService.saveInteraction(interaction);
    }

    @GetMapping("/user/{userId}")
    public List<Interaction> getInteractionsByUser(@PathVariable String userId) {
        return interactionService.getInteractionsByUser(userId);
    }

    @GetMapping("/item/{itemId}")
    public List<Interaction> getInteractionsByItem(@PathVariable String itemId) {
        return interactionService.getInteractionsByItem(itemId);
    }
}
