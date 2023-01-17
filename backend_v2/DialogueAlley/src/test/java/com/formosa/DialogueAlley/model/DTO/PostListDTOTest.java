package com.formosa.DialogueAlley.model.DTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PostListDTOTest {

    PostListDTO postListDTO;

    @BeforeEach
    void setUp() {
        postListDTO = new PostListDTO();
        postListDTO.setFirst_name("John");
        postListDTO.setLast_name("Morris");
        postListDTO.setHandle("Doc Holiday");
        postListDTO.setMessage("Lets go over there");
        postListDTO.setDate_time(new Date());
    }

    @Test
    void getFirst_name() {
        assertEquals("John", postListDTO.getFirst_name());
    }

    @Test
    void getLast_name() {
        assertEquals("Morris", postListDTO.getLast_name());
    }

    @Test
    void getHandle() {
        assertEquals("Doc Holiday", postListDTO.getHandle());
    }

    @Test
    void getDate_time() {
        assertEquals(new Date(), postListDTO.getDate_time());
    }

    @Test
    void getMessage() {
        assertEquals("Lets go over there", postListDTO.getMessage());

    }
}