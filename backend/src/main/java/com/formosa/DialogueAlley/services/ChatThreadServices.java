package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.ChatThread;
import com.formosa.DialogueAlley.repository.ChatThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatThreadServices {
    @Autowired
    ChatThreadRepository chatThreadRepository;

    public void saveChatThread(ChatThread chatThread) { // POST/CREATE
        chatThreadRepository.save(chatThread);
    }

    public List<ChatThread> getAllChatThreads() { // GET/READ/PLURAL
        return chatThreadRepository.findAll();
    }

    public ChatThread getChatThreadById(Integer id) { // GET/READ/SINGULAR
        return chatThreadRepository.findById(id).get();
    }

    public void deleteChatThreadById(Integer id) { // DELETE/DELETE
        chatThreadRepository.deleteById(id);
    }

}
