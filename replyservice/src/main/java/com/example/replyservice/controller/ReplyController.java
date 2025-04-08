package com.example.replyservice.controller;

import com.example.replyservice.model.Item;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @PostMapping
    public void receiveMessage(@RequestBody Item item) {

        System.out.println("🟢 Received item:  1111 ");

        System.out.println("🟢 Received item:   " + item.getCategories());
    }
}
