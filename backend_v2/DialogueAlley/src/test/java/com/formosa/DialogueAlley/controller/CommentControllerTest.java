package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.model.DTO.CommentSaveDTO;
import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import com.formosa.DialogueAlley.repository.CommentRepository;
import com.formosa.DialogueAlley.services.CommentServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.reflect.Array.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CommentController.class)
class CommentControllerTest {

    MockMvc mockMvc;

    @Mock
    CommentServices commentServices;

    @Mock
    CommentRepository commentRepository;

    @InjectMocks
    CommentController commentController;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
    }

    @Test
    void addComment() {
        CommentSaveDTO comment = new CommentSaveDTO();
        when(commentServices.saveComment(comment)).thenReturn(true);
        String result = commentController.addComment(comment);
        assertEquals("Comment has been created.", result);

        when(commentServices.saveComment(comment)).thenReturn(false);
        result = commentController.addComment(comment);
        assertEquals("Failed to create a comment.", result);
    }

    @Test
    void getAllComments() {
        Comment comment = new Comment();
        when(commentServices.getCommentById(1)).thenReturn(comment);
        ResponseEntity<Comment> result = commentController.getCommentById(1);
        assertEquals(comment, result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());

//        when(commentServices.getCommentById(1)).thenThrow(NoSuchElementException.class);
//        result = commentController.getCommentById(1);
//        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    void getCommentById() {
        Comment expectedComment = new Comment();
        expectedComment.setComment_id(1);
        when(commentServices.getCommentById(1)).thenReturn(expectedComment);

        ResponseEntity<Comment> result = commentController.getCommentById(1);

        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expectedComment, result.getBody());
        verify(commentServices, times(1)).getCommentById(1);
    }

    @Test
    void deleteCommentById() {
        commentController.deleteCCommentById(1);
        verify(commentServices, times(1)).deleteCommentById(1);
    }

    @Test
    void findCommentsByPost() {
        List<PostListDTO> comments = new ArrayList<>();
        comments.add(new PostListDTO());
        when(commentRepository.findAllCommentsByPostId(1)).thenReturn(comments);
        List<PostListDTO> result = commentController.findCommentsByPost(1);
        assertEquals(comments, result);
    }
}