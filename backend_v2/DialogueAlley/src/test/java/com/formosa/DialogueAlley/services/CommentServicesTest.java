package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.model.DTO.CommentSaveDTO;
import com.formosa.DialogueAlley.repository.AccountRepository;
import com.formosa.DialogueAlley.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServicesTest {

    @InjectMocks
    CommentServices commentServices = new CommentServices();

    @Mock
    CommentRepository commentRepository;

    @Mock
    AccountRepository accountRepository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveComment() {
        CommentSaveDTO commentDTO = new CommentSaveDTO();
        commentDTO.setAccount_id(1);
        commentDTO.setMessage("You're an asshole");
        Account account = new Account();
        Optional<Account> accountOptional = Optional.of(account);
        when(accountRepository.findById(1)).thenReturn(accountOptional);
        Boolean expected = true;
        Boolean actual = commentServices.saveComment(commentDTO);
        Assertions.assertEquals(expected, actual);
        verify(commentRepository, times(1)).save(any(Comment.class));
    }

    @Test
    void getAllComments() {
        List<Comment> commentList = new ArrayList<>();
        when(commentRepository.findAll()).thenReturn(commentList);
        commentServices.getAllComments();
        verify(commentRepository).findAll();
    }

    @Test
    void getCommentById() {
        Comment comment = new Comment();
        when(commentRepository.findById(anyInt())).thenReturn(Optional.of((comment)));
        commentServices.getCommentById(1);
        verify(commentRepository).findById(1);
    }

    @Test
    void deleteCommentById() {
        commentServices.deleteCommentById(1);
        verify(commentRepository).deleteById(1);
    }
}