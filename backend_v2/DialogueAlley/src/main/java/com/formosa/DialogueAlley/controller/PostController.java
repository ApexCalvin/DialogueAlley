package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.DTO.CommentSaveDTO;
import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import com.formosa.DialogueAlley.model.DTO.PostSaveDTO;
import com.formosa.DialogueAlley.model.Post;
import com.formosa.DialogueAlley.repository.PostRepository;
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
    PostRepository postRepository;

    PostSaveDTO postSaveDTO;

    Post post;


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

    @GetMapping("/alldesc")
    public List<PostListDTO> getAllPostsDESC() {
        return postRepository.findPostsDESC();
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
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Integer id) {
        try{
            postSaveDTO = new PostSaveDTO();
            postServices.savePost(postSaveDTO);
            postRepository.save(post);
            return new ResponseEntity<>(post, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/searchHandle/{handle}")
    public List<PostListDTO> findPostsByHandle(@PathVariable String handle) {
        return postRepository.findPostsByAccountId(handle);
    }

    @GetMapping("/searchHashtag/{hashtag}")
    public List<PostListDTO> findPostsByHashtag(@PathVariable String hashtag) {
        return postRepository.findPostsByHashtagId(hashtag);
    }
}