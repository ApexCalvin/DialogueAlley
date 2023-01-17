package com.formosa.DialogueAlley.model.DTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInfoDTOTest {

    LoginInfoDTO loginInfoDTO;

    @BeforeEach
    void setUp() {
        loginInfoDTO = new LoginInfoDTO("John", "awesome sauce");
    }

    @Test
    void username() {
        assertEquals("John", loginInfoDTO.getUsername());
    }

    @Test
    void password() {
        assertEquals("awesome sauce", loginInfoDTO.getPassword());
    }
}