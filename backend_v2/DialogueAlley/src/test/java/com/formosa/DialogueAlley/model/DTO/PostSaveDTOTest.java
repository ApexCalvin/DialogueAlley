package com.formosa.DialogueAlley.model.DTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PostSaveDTOTest {

    PostSaveDTO postSaveDTO;

    @BeforeEach
    void setUp() {
        postSaveDTO = new PostSaveDTO();
        postSaveDTO.setAccount_id(1);
        postSaveDTO.setDate_time(new Date());
        postSaveDTO.setMessage("Goodbye");
    }

    @Test
    void getAccount_id() {
        assertEquals(1, postSaveDTO.getAccount_id());
    }

    @Test
    void getDate_time() {
        assertEquals(new Date(), postSaveDTO.getDate_time());
    }

    @Test
    void getMessage() {
        assertEquals("Goodbye", postSaveDTO.getMessage());
    }
}