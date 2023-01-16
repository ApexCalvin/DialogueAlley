package com.formosa.DialogueAlley.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HashtagTest {

    Hashtag hashtag;

    ArrayList<PostHashtagCrossReference> postHashtagCrossReferenceList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        hashtag = new Hashtag();
        hashtag.setHashtag_id(1);
        hashtag.setHashtag("Sharpshooter");
        hashtag.setCrossReferenceToPost(postHashtagCrossReferenceList);

    }

    @Test
    void getHashtag_id() {
        Integer actual = hashtag.getHashtag_id();
        Integer expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHashtag() {
        String actual = hashtag.getHashtag();
        String expected = "Sharpshooter";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getCrossReferenceToPost() {
        List<PostHashtagCrossReference> actual = hashtag.getCrossReferenceToPost();
        List<PostHashtagCrossReference> expected = postHashtagCrossReferenceList;
        Assertions.assertEquals(expected, actual);
    }
}