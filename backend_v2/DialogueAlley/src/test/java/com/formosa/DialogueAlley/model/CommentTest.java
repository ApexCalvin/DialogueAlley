package com.formosa.DialogueAlley.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    Comment comment;

    Post assoc_post;

    Account assoc_account;

    Date date_time;

    List<Comment> postComments = new ArrayList<>();

    @BeforeEach
    void setUp() {
        assoc_account = new Account();
        assoc_post = new Post();
        comment = new Comment();
        postComments.add(comment);
        comment.setComment_id(1);
        comment.setDate_time(date_time);
        comment.setMessage("Whats up");
        comment.setAssoc_post(assoc_post);
        comment.setAssoc_account(assoc_account);
    }

    @Test
    void getComment_id() {
        Integer actual = comment.getComment_id();
        Integer expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDate_time() {
        Date actual = comment.getDate_time();
        Date expected = comment.getDate_time();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getMessage() {
        String actual = comment.getMessage();
        String expected = "Whats up";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAssoc_post() {
        Post actual = comment.getAssoc_post();
        Post expected = assoc_post;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAssoc_account() {
        Account actual = comment.getAssoc_account(assoc_account);
        Account expected = assoc_account;
        Assertions.assertEquals(expected, actual);
    }
}