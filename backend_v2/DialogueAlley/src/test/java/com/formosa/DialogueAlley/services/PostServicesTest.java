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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServicesTest {

    @InjectMocks
    PostServices postServices = new PostServices();
    @Mock
    AccountRepository accountRepository;

    @Mock
    PostRepository postRepository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void savePost() {
//        Account account = new Account();
//        account.setAccount_id(1);
//        accountRepository.save(account);
//
//        PostSaveDTO post = new PostSaveDTO();
//        post.setAccount_id(1);
//        post.setMessage("Hello");
//
//        Post post1 = new Post();
//        post1.setAssoc_account(account);
//        post1.setMessage("Hello");
//
//        when(postRepository.save(any(Post.class))).thenReturn(post1);
//        postServices.savePost(post);
//        verify(postRepository).save(post1);
//    }

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
        postServices.deletePostById(1);
        verify(postRepository).deleteById(1);
    }
}