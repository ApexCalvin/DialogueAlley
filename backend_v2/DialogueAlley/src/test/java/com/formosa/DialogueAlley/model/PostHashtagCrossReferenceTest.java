package com.formosa.DialogueAlley.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PostHashtagCrossReferenceTest {

    List<PostHashtagCrossReference> postHashtagCrossReferenceList = new ArrayList<>();

    Post post;

    Hashtag hashtag;

//    @BeforeEach
//    void setUp() {
//        post = new Post();
//        post.setPost_id(1);
//        hashtag = new Hashtag();
//        hashtag.setHashtag_id(1);
//        postHashtagCrossReferenceList.add(0, hashtag);
//        postHashtagCrossReferenceList.setHashtag(hashtag);
//        postHashtagCrossReferenceList.setXref_id(1);
//
//    }
//
//    @Test
//    void getXref_id() {
//        Integer actual = postHashtagCrossReferenceList.get();
//        Integer expected = 1;
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void getPost() {
//        Post actual = postHashtagCrossReference.getPost();
//        Post expected = post;
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void getHashtag() {
//    }
}