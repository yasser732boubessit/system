package com.example.replyservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "replies")
public class Reply {

    @Id
    private String id;
    private String content;
    private String userId;
    private String itemId;
    private long timestamp;

    public Reply() {}

    public Reply(String content, String userId, String itemId, long timestamp) {
        this.content = content;
        this.userId = userId;
        this.itemId = itemId;
        this.timestamp = timestamp;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
