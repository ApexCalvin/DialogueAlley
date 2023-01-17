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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostRepository postRepository;

    @MockBean
    AccountServices accountServices;

    @Autowired
    WebApplicationContext webApplicationContext;

    @InjectMocks
    AccountController accountController;

    AccountControllerTest() throws JsonProcessingException {
    }
    Account account= new Account();
    ObjectMapper objectMapper = new ObjectMapper();
    String accountJson = objectMapper.writeValueAsString(account);

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        MockitoAnnotations.initMocks(this);
        account.setAccount_id(123);
    }


    @Test
    void shouldCreateMockMvc() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void addAccount() throws Exception {
            mockMvc.perform(post("/account/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(accountJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAllAccounts() throws Exception{
        mockMvc.perform(get("/account/all")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

    }

    @Test
    void getAccountById() throws Exception {
        when(accountServices.getAccountById(anyInt())).thenReturn(account);

        mockMvc.perform(get("/account/123")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.account_id").value(123));
    }
    @Test
    void getAccountByIdFailed() throws Exception {
        //when(accountServices.getAccountById(anyInt())).thenReturn(account);

        mockMvc.perform(get("/account/xx")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().is4xxClientError());
    }
    @Test
    void updateAccount() throws Exception {
        mockMvc.perform(put("/account/123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(accountJson))
                        .andExpect(status().isOk())
                        .andReturn();
    }

    @Test
    void deleteAccountById() throws Exception {
        mockMvc.perform(delete("/account/123")
                        .param("account_id","123")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
    }

    @Test
    void getLoginInfo() {
    }
}