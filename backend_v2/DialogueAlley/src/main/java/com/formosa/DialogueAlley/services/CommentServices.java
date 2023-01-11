package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.model.DTO.CommentSaveDTO;
import com.formosa.DialogueAlley.repository.AccountRepository;
import com.formosa.DialogueAlley.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServices {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    AccountRepository accountRepository;

    public Boolean saveComment(CommentSaveDTO comment) { // POST/CREATE
        Optional<Account> account = accountRepository.findById(comment.getAccount_id());

        if (account.isPresent()){
            Comment comment1 = new Comment();
           // comment1.getAssoc_account(account.get());
            if (comment.getDate_time() != null) {
                //comment1.setDate_time(comment.getDate_time());
            } else {
                //comment1.setDate_time(new Date());
            }
            comment1.setMessage(comment.getMessage());
            commentRepository.save(comment1);
            return true;
        }
        return false;
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