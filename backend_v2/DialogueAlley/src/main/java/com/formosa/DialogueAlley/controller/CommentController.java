package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.services.CommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/comments")
@CrossOrigin("http://localhost:3000")
public class CommentController {
    @Autowired
    CommentServices commentServices;

    @PostMapping("/add")
    public String addComment(@RequestBody Comment comment) {
        commentServices.saveComment(comment);
        return "Comment has been created.";
    }

    @GetMapping("/all")
    public List<Comment> getAllComments() {
        return commentServices.getAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        try {
            Comment comment = commentServices.getCommentById(id);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable Integer id) {
        try{
            commentServices.saveComment(comment);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCCommentById(@PathVariable Integer id) {
        commentServices.deleteCommentById(id);
        return "Comment "+id+" has been deleted.";
    }
}
