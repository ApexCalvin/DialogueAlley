package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Hashtag;
import com.formosa.DialogueAlley.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashtagServices {
    @Autowired
    HashtagRepository hashtagRepository;

    public void saveHashtag(Hashtag hashtag) { // POST/CREATE
        hashtagRepository.save(hashtag);
    }

    public List<Hashtag> getAllHashtags() { // GET/READ/PLURAL
        return hashtagRepository.findAll();
    }

    public Hashtag getHashtagById(Integer id) { // GET/READ/SINGULAR
        return hashtagRepository.findById(id).get();
    }

    public void deleteHashtagById(Integer id) { // DELETE/DELETE
        hashtagRepository.deleteById(id);
    }
}