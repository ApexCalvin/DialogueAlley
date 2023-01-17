package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.model.DTO.PostSaveDTO;
import com.formosa.DialogueAlley.model.Post;
import com.formosa.DialogueAlley.repository.AccountRepository;
import com.formosa.DialogueAlley.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServicesTest {

    @InjectMocks
    PostServices postServices;

    @Mock
    AccountRepository accountRepository;

    @Mock
    PostRepository postRepository;

    List<Post> postList;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void savePost() {
        PostSaveDTO postDTO = new PostSaveDTO();
        postDTO.setAccount_id(1);
        postDTO.setMessage("You're an asshole");
        Account account = new Account();
        Optional<Account> accountOptional = Optional.of(account);
        when(accountRepository.findById(1)).thenReturn(accountOptional);
        Boolean expected = true;
        Boolean actual = postServices.savePost(postDTO);
        assertEquals(expected, actual);
        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    void savePostWithDate() {
        PostSaveDTO postDTO = new PostSaveDTO();
        postDTO.setAccount_id(1);
        postDTO.setMessage("You're an asshole");
        postDTO.setDate_time(new Date());
        Account account = new Account();
        Optional<Account> accountOptional = Optional.of(account);
        when(accountRepository.findById(1)).thenReturn(accountOptional);
        Boolean expected = true;
        Boolean actual = postServices.savePost(postDTO);
        assertEquals(expected, actual);
        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    void getAllPosts() {
        List<Post> postList = new ArrayList<>();
        when(postRepository.findAll()).thenReturn(postList);
        postServices.getAllPosts();
        verify(postRepository).findAll();
    }

    @Test
    void getPostById() {
        Post post = new Post();
        when(postRepository.findById(anyInt())).thenReturn(Optional.of((post)));
        postServices.getPostById(1);
        verify(postRepository).findById(1);
    }

    @Test
    void deletePostById() {
    }
}