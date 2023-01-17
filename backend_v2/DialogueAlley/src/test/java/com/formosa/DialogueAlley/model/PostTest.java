package com.formosa.DialogueAlley.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class PostTest {

    Post post;

    Comment comment;

    Account assoc_account;

    Date date_time;

    List<Comment> postComments;

    List<PostHashtagCrossReference> crossReferenceToHashtag;

    @BeforeEach
    void setUp() {
        assoc_account = new Account();
        comment = new Comment();
        date_time = new Date();
        post = new Post();
        crossReferenceToHashtag = new ArrayList<>();
        post.setPost_id(1);
        post.setDate_time(date_time);
        post.setMessage("You're an asshole");
        post.setAssoc_account(assoc_account);
        post.setCrossReferenceToHashtag(crossReferenceToHashtag);
        post.setPostComments(postComments);
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
        List<Comment> expected = postComments;
        List<Comment> actual = post.getPostComments();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getCrossReferenceToHashtag() {
        PostHashtagCrossReference crossRef1 = new PostHashtagCrossReference();
        crossReferenceToHashtag.add(crossRef1);
        PostHashtagCrossReference crossRef2 = new PostHashtagCrossReference();
        crossReferenceToHashtag.add(crossRef2);
        post.setCrossReferenceToHashtag(crossReferenceToHashtag);
        List<PostHashtagCrossReference> returnedCrossReferences = post.getCrossReferenceToHashtag();
        Assertions.assertEquals(crossReferenceToHashtag, returnedCrossReferences);
    }
}