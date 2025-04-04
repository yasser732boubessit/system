package com.example.replyservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @JsonProperty("ItemType")
    private String itemType;

    @JsonProperty("Domain")
    private int domain;

    @JsonProperty("CreatedAt")
    private String createdAt;

    @JsonProperty("ItemID")
    private long itemId;

    @JsonProperty("Recommendable")
    private boolean recommendable;

    @JsonProperty("URL")
    private String url;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("category")
    private int category;

    @JsonProperty("text")
    private String text;

    @JsonProperty("keywords")
    private String keywords;

    @JsonProperty("categories")
    private String categories;
}
