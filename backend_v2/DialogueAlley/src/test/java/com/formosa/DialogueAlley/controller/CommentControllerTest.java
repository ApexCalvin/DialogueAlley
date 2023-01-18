package com.formosa.DialogueAlley.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formosa.DialogueAlley.model.Account;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
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

    String commentJson = objectMapper.writeValueAsString(comment);

    CommentControllerTest() throws JsonProcessingException {
    }


    @BeforeEach
    void setUp() {
        commentList = new ArrayList<>();
        post = new Post();
        commentSaveDTO = new CommentSaveDTO();
        comment = new Comment();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
        comment.setComment_id(1);
    }

    @Test
    void shouldCreateMockMvc() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void addComment() throws Exception {
        mockMvc.perform(put("/comment/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(commentJson)))
                        .andExpect(status().isOk())
                        .andReturn();
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

    }
}