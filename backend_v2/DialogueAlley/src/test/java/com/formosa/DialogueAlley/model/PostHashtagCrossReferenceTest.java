package com.formosa.DialogueAlley.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PostHashtagCrossReferenceTest {

    PostHashtagCrossReference postHashtagCrossReference;

    Post post;

    Hashtag hashtag;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setPost_id(1);
        hashtag = new Hashtag();
        hashtag.setHashtag("Cowboy");


    }

    @Test
    void getXref_id() {
        PostHashtagCrossReference xref = new PostHashtagCrossReference();
        Integer expectedId = 1;
        xref.setXref_id(expectedId);
        Integer actualId = xref.getXref_id();
        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
    void getPost() {
        PostHashtagCrossReference xref = new PostHashtagCrossReference();
        Post post = new Post();
        xref.setPost(post);
        Assertions.assertEquals(post, xref.getPost());
    }

    @Test
    void getHashtag() {
        PostHashtagCrossReference xref = new PostHashtagCrossReference();
        Hashtag hashtag = new Hashtag();
        xref.setHashtag(hashtag);
        Assertions.assertEquals(hashtag, xref.getHashtag());
    }
}