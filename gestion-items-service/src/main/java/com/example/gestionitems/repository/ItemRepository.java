package com.example.gestionitems.repository;

import com.example.gestionitems.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
