package com.formosa.DialogueAlley.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formosa.DialogueAlley.model.PostHashtagCrossReference;
import com.formosa.DialogueAlley.repository.PostHashtagCrossReferenceRepository;
import com.formosa.DialogueAlley.services.PostHashtagCrossReferenceServices;
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
@WebMvcTest(PostHashtagCrossReferenceController.class)
@AutoConfigureMockMvc
class PostHashtagCrossReferenceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostHashtagCrossReferenceRepository postHashtagCrossReferenceRepository;

    @MockBean
    PostHashtagCrossReferenceServices crossReferenceServices;

    @InjectMocks
    PostHashtagCrossReferenceController postHashtagCrossReferenceController;

    @Autowired
    WebApplicationContext webApplicationContext;

    PostHashtagCrossReference postHashtagCrossReference;

    ObjectMapper objectMapper = new ObjectMapper();

    String crossRefJson;

    PostHashtagCrossReferenceControllerTest() throws JsonProcessingException {
    }


    @BeforeEach
    void setUp() throws JsonProcessingException {
        postHashtagCrossReference = new PostHashtagCrossReference();
        postHashtagCrossReference.setXref_id(1);
        crossRefJson = objectMapper.writeValueAsString(postHashtagCrossReference);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(postHashtagCrossReferenceController).build();
    }

    @Test
    void shouldCreateMockMvc() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void addCrossRef() throws Exception {
        mockMvc.perform(post("/crossRef/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(crossRefJson)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAllCrossRefs() throws Exception {
        mockMvc.perform(get("/crossRef/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getCrossRefById() throws Exception {
        when(crossReferenceServices.getCrossReferenceById(anyInt())).thenReturn(postHashtagCrossReference);

        mockMvc.perform(get("/crossRef/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.xref_id").value(1));
    }

    @Test
    void getCrossRefByIdFailed() throws JsonProcessingException{
        PostHashtagCrossReferenceController postHashtagCrossReferenceController = new PostHashtagCrossReferenceController();
        postHashtagCrossReferenceController.crossReference = mock(PostHashtagCrossReferenceServices.class);
        when(postHashtagCrossReferenceController.crossReference.getCrossReferenceById(1)).thenThrow(new NoSuchElementException());

        ResponseEntity<PostHashtagCrossReference> response = postHashtagCrossReferenceController.getCrossRefById(1);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void updateCrossRef() throws Exception {
        mockMvc.perform(put("/crossRef/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(crossRefJson)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void deleteCrossRefById() throws Exception {
        mockMvc.perform(delete("/crossRef/1")
                        .param("xref_id","1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}