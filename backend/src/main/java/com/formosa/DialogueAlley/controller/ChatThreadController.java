package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.ChatThread;
import com.formosa.DialogueAlley.services.ChatThreadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/chatThread")
@CrossOrigin("http://localhost:3000")
public class ChatThreadController {
    @Autowired
    ChatThreadServices chatThreadServices;

    @PostMapping("/add")
    public String addChatThread(@RequestBody ChatThread chatThread) {
        chatThreadServices.saveChatThread(chatThread);
        return "ChatThread has been created.";
    }

    @GetMapping("/all")
    public List<ChatThread> getAllChatThreads() {
        return chatThreadServices.getAllChatThreads();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatThread> getChatThreadById(@PathVariable Integer id) {
        try {
            ChatThread chatThread = chatThreadServices.getChatThreadById(id);
            return new ResponseEntity<>(chatThread, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatThread> ChatThread(@RequestBody ChatThread chatThread, @PathVariable Integer id) {
        try{
            chatThreadServices.saveChatThread(chatThread);
            return new ResponseEntity<>(chatThread, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteChatThreadById(@PathVariable Integer id) {
        chatThreadServices.deleteChatThreadById(id);
        return "ChatThread "+id+" has been deleted.";
    }
}
