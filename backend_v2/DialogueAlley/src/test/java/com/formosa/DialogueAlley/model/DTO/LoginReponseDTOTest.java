package com.formosa.DialogueAlley.model.DTO;

import com.formosa.DialogueAlley.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginReponseDTOTest {

    LoginReponseDTO loginReponseDTO;

    Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
        loginReponseDTO = new LoginReponseDTO(account, "Success");
    }

    @Test
    void account() {
        assertEquals(account, loginReponseDTO.account());
    }

    @Test
    void string() {
        assertEquals("Success", loginReponseDTO.string());
    }
}