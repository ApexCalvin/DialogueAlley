package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.model.DTO.CommentSaveDTO;
import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import com.formosa.DialogueAlley.repository.CommentRepository;
import com.formosa.DialogueAlley.services.CommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/comment")
@CrossOrigin("http://localhost:3000")
public class CommentController {
    @Autowired
    CommentServices commentServices;

    @Autowired
    CommentRepository commentRepository;

    @PostMapping("/add")
    public String addComment(@RequestBody CommentSaveDTO comment) {
        boolean exist = commentServices.saveComment(comment);

        if (exist) {
            return "Comment has been created.";
        } else {
            return "Failed to create a comment.";
        }
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

//    @PutMapping("/{id}")
//    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable Integer id) {
//        try{
//            CommentSaveDTO commentSaveDTO = new CommentSaveDTO();
//            commentServices.saveComment(commentSaveDTO);
//            commentRepository.save(comment);
//            return new ResponseEntity<>(comment, HttpStatus.OK);
//        }catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public String deleteCCommentById(@PathVariable Integer id) {
        commentServices.deleteCommentById(id);
        return "Comment "+id+" has been deleted.";
    }

    @GetMapping("/allComments/{id}")
    public List<PostListDTO> findCommentsByPost(@PathVariable Integer id) {
        return commentRepository.findAllCommentsByPostId(id);
    }
}
