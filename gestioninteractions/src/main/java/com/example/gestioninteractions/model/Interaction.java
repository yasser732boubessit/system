package com.example.gestioninteractions.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "interactions")
public class Interaction {
    @Id
    private String id;
    private String userId;
    private String itemId;
    private String type; // Ex: "click", "like", "share"
    private LocalDateTime timestamp;

    public Interaction() {
        this.timestamp = LocalDateTime.now();
    }

    // Getters et Setters
}
