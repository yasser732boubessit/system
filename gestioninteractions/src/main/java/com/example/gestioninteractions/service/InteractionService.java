package com.example.gestioninteractions.service;

import com.example.gestioninteractions.model.Interaction;
import com.example.gestioninteractions.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionService {

    @Autowired
    private InteractionRepository interactionRepository;

    public List<Interaction> getAllInteractions() {
        return interactionRepository.findAll();
    }

    public Interaction saveInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }

    public List<Interaction> getInteractionsByUser(String userId) {
        return interactionRepository.findByUserId(userId);
    }

    public List<Interaction> getInteractionsByItem(String itemId) {
        return interactionRepository.findByItemId(itemId);
    }
}
