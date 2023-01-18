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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.NoSuchElementException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
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

    @InjectMocks
    AccountController accountController;

    @Autowired
    WebApplicationContext webApplicationContext;


    AccountControllerTest() throws JsonProcessingException {
    }
    Account account;
    ObjectMapper objectMapper = new ObjectMapper();
    String accountJson = objectMapper.writeValueAsString(account);

    @BeforeEach
    void setUp() {
        account = new Account();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        account.setAccount_id(123);
    }

    @Test
    void shouldCreateMockMvc() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void addAccount() throws Exception {
            mockMvc.perform(put("/account/add")
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
    void getAccountByIdFailed() throws Exception{
        AccountController accountController = new AccountController();
        accountController.accountServices = mock(AccountServices.class);
        when(accountController.accountServices.getAccountById(1)).thenThrow(new NoSuchElementException());

        ResponseEntity<Account> response = accountController.getAccountById(1);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    @Test
    void updateAccount() throws Exception{
        mockMvc.perform(patch("/account/123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(accountJson))
                        .andExpect(status().isOk())
                        .andReturn();
    }

    @Test
    void updateAccountFailed() throws Exception{
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