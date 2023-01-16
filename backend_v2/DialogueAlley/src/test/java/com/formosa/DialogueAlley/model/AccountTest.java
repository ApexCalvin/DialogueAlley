package com.formosa.DialogueAlley.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AccountTest {

    Account account;
    List<Post> userPosts = new ArrayList<>();

    @BeforeEach
    void setUp() {
        account = new Account();
        Post post = new Post();
        userPosts.add(post);
        account.setAccount_id(1);
        account.setUsername("Marchington");
        account.setPassword("password");
        account.setFirst_name("John");
        account.setLast_name("Morris");
        account.setHandle("DocHoliday");
        account.setUserPosts(userPosts);
    }

    @Test
    void getAccount_id() {
        Integer actual = account.getAccount_id();
        Integer expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getUsername() {
        String actual = account.getUsername();
        String expected = "Marchington";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPassword() {
        String actual = account.getPassword();
        String expected = "password";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getFirst_name() {
        String actual = account.getFirst_name();
        String expected = "John";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getLast_name() {
        String actual = account.getLast_name();
        String expected = "Morris";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHandle() {
        String actual = account.getHandle();
        String expected = "DocHoliday";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getUserPosts() {
        List<Post> actual = account.getUserPosts();
        List<Post> expected = userPosts;
        Assertions.assertEquals(expected, actual);
    }
}