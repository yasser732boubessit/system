package com.example.replyservice.repository;

import com.example.replyservice.model.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReplyRepository extends MongoRepository<Reply, String> {
    List<Reply> findByItemId(String itemId);
}
