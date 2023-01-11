package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import com.formosa.DialogueAlley.model.DTO.PostSaveDTO;
import com.formosa.DialogueAlley.model.Post;
import com.formosa.DialogueAlley.repository.AccountRepository;
import com.formosa.DialogueAlley.repository.PostRepository;
import com.formosa.DialogueAlley.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@RequestMapping("/post")
@CrossOrigin("http://localhost:3000")
public class PostController {
    @Autowired
    PostServices postServices;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PostRepository postRepository;


    @PostMapping("/add")
    public String addPost(@RequestBody PostSaveDTO post) {

        boolean exist = postServices.savePost(post);

        if (exist) {
            return "Post has been created.";
        } else {
            return "Failed to create a post.";
        }
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

//    @PutMapping("/{id}")
//    public ResponseEntity<Post> updateProfile(@RequestBody Post post, @PathVariable Integer id) {
//        try{
//            postServices.savePost(post);
//            return new ResponseEntity<>(post, HttpStatus.OK);
//        }catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/searchHandle/{handle}")
    public List<PostListDTO> findPostsByHandle(@PathVariable String handle) {
        return postRepository.findPostsByAccountId(handle);
    }

//    @GetMapping("/searchHashtag/{hashtag}")
//    public List<Post> findPostsByHashtag(@PathVariable String hashtag) {
//        return postServices.findPostsByHashtag(hashtag);
//    }
}