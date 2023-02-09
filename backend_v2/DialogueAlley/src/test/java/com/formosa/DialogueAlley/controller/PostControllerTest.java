package com.formosa.DialogueAlley.controller;

import aj.org.objectweb.asm.Handle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import com.formosa.DialogueAlley.model.DTO.PostSaveDTO;
import com.formosa.DialogueAlley.model.Post;
import com.formosa.DialogueAlley.repository.AccountRepository;
import com.formosa.DialogueAlley.repository.PostRepository;
import com.formosa.DialogueAlley.services.PostServices;
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

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PostController.class)
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostRepository postRepository;

    @MockBean
    PostServices postServices;

    @InjectMocks
    PostController postController;

    @Autowired
    WebApplicationContext webApplicationContext;


    PostControllerTest() throws JsonProcessingException {
    }

    PostSaveDTO postSaveDTO;

    Handle handle;

    Date date;
    PostListDTO postListDTO;
    List<PostListDTO> postListList;
    Post post;
    Account account;
    ObjectMapper objectMapper = new ObjectMapper();

    String postJson;
    @MockBean
    private AccountRepository accountRepository;


    @BeforeEach
    void setUp() throws JsonProcessingException {
        post = new Post();
        postListDTO = new PostListDTO();
        postListDTO.setHandle("cowboy");
        postListList = new ArrayList<>();
        postListList.add(postListDTO);
        account = new Account();
        account.setAccount_id(1);
        account.setHandle("cowboy");
        post.setPost_id(1);
        post.setAssoc_account(account);
        postJson = objectMapper.writeValueAsString(post);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    @Test
    void shouldCreateMockMvc() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void addPost() throws Exception {
        mockMvc.perform(post("/post/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(postJson)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAllPosts() throws Exception {
        mockMvc.perform(get("/post/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deletePostById() throws Exception {
        mockMvc.perform(delete("/post/1")
                        .param("post_id", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getProfileById() throws Exception {
        when(postServices.getPostById(anyInt())).thenReturn(post);

        mockMvc.perform(get("/post/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.post_id").value(1));
    }

    @Test
    void getProfileByIdFailed() {
        PostController postController = new PostController();
        postController.postServices = mock(PostServices.class);
        when(postController.postServices.getPostById(1)).thenThrow(new NoSuchElementException());

        ResponseEntity<Post> response = postController.getProfileById(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void findPostsByHandle() throws Exception {
        when(postRepository.findPostsByAccountId("cowboy")).thenReturn(postListList);
        mockMvc.perform(get("/post/searchHandle/cowboy")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void findPostsByHandleFailed() {
        PostController postController = new PostController();
        postController.postServices = mock(PostServices.class);
        when(postController.postServices.getPostById(1)).thenThrow(new NoSuchElementException());

        ResponseEntity<Post> response = postController.getProfileById(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void findPostsByHashtag() throws Exception {
        when(postRepository.findPostsByHashtagId("hashtag")).thenReturn(postListList);

        mockMvc.perform(get("/post/searchHashtag/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void UpdatePost() throws Exception {
        mockMvc.perform(put("/post/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void updatePostFailed() {
        try {
            mockMvc.perform(put("/post/update/{id}", post.getPost_id())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(String.valueOf(postSaveDTO)))
                    .andExpect(status().isNotFound())
                    .andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


//    @Test
//    void getAllPostsDESC() throws Exception {
//        when(postRepository.findPostsByAccountId("cowboy")).thenReturn(postListList);
//        mockMvc.perform(get("/post/all/desc"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].post_id").value(anyInt()))
//                .andExpect(jsonPath("$[0].assoc_account.handle").value("cowboy"));
//    }
    }
}