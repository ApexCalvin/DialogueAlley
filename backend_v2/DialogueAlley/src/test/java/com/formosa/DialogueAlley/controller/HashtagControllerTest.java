package com.formosa.DialogueAlley.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.model.Hashtag;
import com.formosa.DialogueAlley.repository.HashtagRepository;
import com.formosa.DialogueAlley.services.HashtagServices;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.NoSuchElementException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(HashtagController.class)
@AutoConfigureMockMvc
class HashtagControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HashtagRepository hashtagRepository;

    @MockBean
    HashtagServices hashtagServices;

    @InjectMocks
    HashtagController hashtagController;

    @Autowired
    WebApplicationContext webApplicationContext;


    HashtagControllerTest() throws JsonProcessingException {
    }

    Hashtag hashtag;

    ObjectMapper objectMapper = new ObjectMapper();

    String hashtagJson;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        hashtag = new Hashtag();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hashtagController).build();
        hashtag.setHashtag_id(1);
        hashtagJson = objectMapper.writeValueAsString(hashtag);
    }

    @Test
    void shouldCreateMockMvc() {
        Assertions.assertNotNull(mockMvc);
    }


    @Test
    void addHashtag() throws Exception{
        mockMvc.perform(post("/hashtag/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hashtagJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAllHashtags() throws Exception {
        mockMvc.perform(get("/hashtag/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getHashtagById() throws Exception  {
        when(hashtagServices.getHashtagById(anyInt())).thenReturn(hashtag);

        mockMvc.perform(get("/hashtag/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hashtag_id").value(1));
    }

    @Test
    void getHashtagByIdFailed() throws Exception{
        HashtagController hashtagController = new HashtagController();
        hashtagController.hashtagServices = mock(HashtagServices.class);
        when(hashtagController.hashtagServices.getHashtagById(1)).thenThrow(new NoSuchElementException());

        ResponseEntity<Hashtag> response = hashtagController.getHashtagById(1);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void updateHashtag() throws Exception {
        mockMvc.perform(put("/hashtag/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hashtagJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void deleteHashtagById() throws Exception {
        mockMvc.perform(delete("/hashtag/1")
                        .param("hashtag_id","1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}