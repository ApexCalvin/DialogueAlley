package com.formosa.DialogueAlley.model.DTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CommentSaveDTOTest {

    CommentSaveDTO commentSaveDTO;

    @BeforeEach
    void setUp() {
        commentSaveDTO = new CommentSaveDTO();
        commentSaveDTO.setAccount_id(1);
        commentSaveDTO.setDate_time(new Date());
        commentSaveDTO.setMessage("Hidy Ho");
    }

    @Test
    void getAccount_id() {
        commentSaveDTO.setAccount_id(1);
        assertEquals(1, commentSaveDTO.getAccount_id());
    }

    @Test
    void getDate_time() {
        Date date = new Date();
        commentSaveDTO.setDate_time(date);
        assertEquals(date, commentSaveDTO.getDate_time());
    }

    @Test
    void getMessage() {
        commentSaveDTO.setMessage("test message");
        assertEquals("test message", commentSaveDTO.getMessage());
    }
}