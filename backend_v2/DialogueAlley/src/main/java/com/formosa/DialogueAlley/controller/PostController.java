package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.Post;
import com.formosa.DialogueAlley.repository.AccountRepository;
import com.formosa.DialogueAlley.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/post")
@CrossOrigin("http://localhost:3000")
public class PostController {

    @Autowired
    PostServices postServices;
    @Autowired
    private AccountRepository profileRepository;

    @PostMapping("/add")
    public String addPost(@RequestBody Post post) {
        postServices.savePost(post);
        return "Post has been created.";
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postServices.getAllPosts();
    }

    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable Integer id) {
        postServices.deletePostById(id);
        return "Post "+id+" has been deleted.";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getProfileById(@PathVariable Integer id) {
        try {
            Post post = postServices.getPostById(id);
            return new ResponseEntity<>(post, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updateProfile(@RequestBody Post post, @PathVariable Integer id) {
        try{
            postServices.savePost(post);
            return new ResponseEntity<>(post, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}