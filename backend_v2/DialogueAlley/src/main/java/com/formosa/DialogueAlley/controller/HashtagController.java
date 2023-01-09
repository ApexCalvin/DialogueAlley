package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.Hashtag;
import com.formosa.DialogueAlley.services.HashtagServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hashtag")
@CrossOrigin("http://localhost:3000")
public class HashtagController {
    @Autowired
    HashtagServices hashtagServices;

    @PostMapping("/add")
    public String addHashtag(@RequestBody Hashtag hashtag) {
        hashtagServices.saveHashtag(hashtag);
        return "Hashtag has been created.";
    }

    @GetMapping("/all")
    public List<Hashtag> getAllHashtags() {
        return hashtagServices.getAllHashtags();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hashtag> getHashtagById(@PathVariable Integer id) {
        try {
            Hashtag hashtag = hashtagServices.getHashtagById(id);
            return new ResponseEntity<>(hashtag, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hashtag> updateHashtag(@RequestBody Hashtag hashtag, @PathVariable Integer id) {
        try{
            hashtagServices.saveHashtag(hashtag);
            return new ResponseEntity<>(hashtag, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteHashtagById(@PathVariable Integer id) {
        hashtagServices.deleteHashtagById(id);
        return "Hashtag "+id+" has been deleted.";
    }
}