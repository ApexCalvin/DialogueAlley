package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServices {
    @Autowired
    CommentRepository commentRepository;

    public void saveComment(Comment chatThread) { // POST/CREATE
        commentRepository.save(chatThread);
    }

    public List<Comment> getAllComments() { // GET/READ/PLURAL
        return commentRepository.findAll();
    }

    public Comment getCommentById(Integer id) { // GET/READ/SINGULAR
        return commentRepository.findById(id).get();
    }

    public void deleteCommentById(Integer id) { // DELETE/DELETE
        commentRepository.deleteById(id);
    }

}