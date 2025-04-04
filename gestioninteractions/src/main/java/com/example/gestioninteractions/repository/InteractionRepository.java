package com.example.gestioninteractions.repository;

import com.example.gestioninteractions.model.Interaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface InteractionRepository extends MongoRepository<Interaction, String> {
    List<Interaction> findByUserId(String userId);
    List<Interaction> findByItemId(String itemId);
}
