package com.formosa.DialogueAlley.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class PostTest {

    Post post;

    List<Comment> postComments = new ArrayList<>();

    List<PostHashtagCrossReference> crossReferenceToHashtag = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Account assoc_account = new Account();
        Comment comment = new Comment();
        Date date_time = new Date();
        post = new Post();
        postComments.add(comment);
        post.setPost_id(1);
        post.setDate_time(date_time);
        post.setMessage("You're an asshole");
        post.setAssoc_account(assoc_account);
        post.setCrossReferenceToHashtag(crossReferenceToHashtag);
    }

    @Test
    void getPost_id() {
        Integer actual = post.getPost_id();
        Integer expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDate_time() {
        Date actual = post.getDate_time();
        Date expected = post.getDate_time();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getMessage() {
        String actual = post.getMessage();
        String expected = "You're an asshole";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAssoc_account() {
        Account actual = post.getAssoc_account();
        Account expected = post.getAssoc_account();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPostComments() {
        List<Comment> actual = post.getPostComments();
        List<Comment> expected = postComments;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getCrossReferenceToHashtag() {
    }
}