package com.formosa.DialogueAlley.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.repository.PostRepository;
import com.formosa.DialogueAlley.services.AccountServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AccountController.class)
class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    PostRepository postRepository;

    @MockBean
    AccountServices accountServices;

    @Autowired
    WebApplicationContext webApplicationContext;

    @InjectMocks
    AccountController accountController;

    AccountControllerTest() throws JsonProcessingException {
    }

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }


    Account account= new Account();
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(account);

    @Test
    void shouldCreateMockMvc() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void addAccount() throws Exception {
            mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();
               // .andExpect(content())
    }

    @Test
    void getAllAccounts() {
    }

    @Test
    void getAccountById() {
    }

    @Test
    void updateAccount() {
    }

    @Test
    void deleteAccountById() {
    }

    @Test
    void getLoginInfo() {
    }
}