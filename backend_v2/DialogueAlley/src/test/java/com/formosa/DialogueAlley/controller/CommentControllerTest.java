package com.formosa.DialogueAlley.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.model.DTO.CommentSaveDTO;
import com.formosa.DialogueAlley.model.Post;
import com.formosa.DialogueAlley.repository.CommentRepository;
import com.formosa.DialogueAlley.services.CommentServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CommentController.class)
@AutoConfigureMockMvc
class CommentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CommentServices commentServices;

    @MockBean
    CommentRepository commentRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    @InjectMocks
    CommentController commentController;

    Post post;

    Comment comment;

    List<Comment> commentList;

    CommentSaveDTO commentSaveDTO;

    ObjectMapper objectMapper = new ObjectMapper();

    String commentJson;

    CommentControllerTest() throws JsonProcessingException {
    }


    @BeforeEach
    void setUp() throws JsonProcessingException {
        commentList = new ArrayList<>();
        post = new Post();
        commentSaveDTO = new CommentSaveDTO();
        comment = new Comment();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
        comment.setComment_id(1);
        commentJson = objectMapper.writeValueAsString(comment);
    }

    @Test
    void shouldCreateMockMvc() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void addComment() throws Exception {
        mockMvc.perform(post("/comment/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(commentJson)))
                        .andExpect(status().isOk())
                        .andReturn();
    }

    @Test
    void addCommentFailed() {
        when(commentServices.getCommentById(1)).thenThrow(new NoSuchElementException());

        ResponseEntity<Comment> response = commentController.getCommentById(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getAllComments() throws Exception {
        commentList = new ArrayList<>();
        mockMvc.perform(get("/comment/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getCommentById() throws Exception {
        when(commentServices.getCommentById(anyInt())).thenReturn(comment);

        mockMvc.perform(get("/comment/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.comment_id").value(1));
    }

    @Test
    void deleteCommentById() throws Exception {
        mockMvc.perform(delete("/comment/1")
                        .param("comment_id","1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void findCommentsByPost() throws Exception {
        when(commentServices.getCommentById(1)).thenReturn(comment);
        mockMvc.perform(get("/comment/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.comment_id").value(1));
    }

    @Test
    void updateComment() throws Exception {
        mockMvc.perform(put("/comment/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(commentJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void updateCommentFailed() {
        //Act and Assert
        try {
            mockMvc.perform(put("/comment/update/{id}", comment.getComment_id())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(String.valueOf(commentSaveDTO)))
                    .andExpect(status().isNotFound())
                    .andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}