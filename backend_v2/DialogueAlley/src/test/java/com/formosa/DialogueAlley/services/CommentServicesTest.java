package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.model.DTO.CommentSaveDTO;
import com.formosa.DialogueAlley.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentServicesTest {

    @InjectMocks
    CommentServices commentServices = new CommentServices();

    @Mock
    CommentRepository commentRepository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void saveComment() {
//        Comment comment1 = new Comment();
//        when(commentRepository.save(any(Comment.class))).thenReturn(comment1);
//        commentServices.saveComment(comment1);
//        verify(commentRepository).save(comment1);
//    }

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