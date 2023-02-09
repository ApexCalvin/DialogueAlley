package com.formosa.DialogueAlley.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.repository.AccountRepository;
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

import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountRepository accountRepository;

    @MockBean
    AccountServices accountServices;

    @InjectMocks
    AccountController accountController;

    @Autowired
    WebApplicationContext webApplicationContext;

    List<Account> accountList;
    Account account;
    ObjectMapper objectMapper = new ObjectMapper();
    String accountJson;

    AccountControllerTest() throws JsonProcessingException {
    }

    @BeforeEach
    void setUp() throws JsonProcessingException{
        account = new Account();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        account.setAccount_id(123);
        accountJson = objectMapper.writeValueAsString(account);
    }

    @Test
    void shouldCreateMockMvc() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void addAccount() throws Exception {
        Account account = new Account();
        accountJson = objectMapper.writeValueAsString(account);
        mockMvc.perform(post("/account/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(accountJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Account has been created."));
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
    void getAccountByIdFailed() {
        AccountController accountController = new AccountController();
        accountController.accountServices = mock(AccountServices.class);
        when(accountController.accountServices.getAccountById(1)).thenThrow(new NoSuchElementException());

        ResponseEntity<Account> response = accountController.getAccountById(1);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    @Test
    void updateAccount() throws Exception{
        mockMvc.perform(put("/account/{id}",123)
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
                        .param("$.account_id","123")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
    }

    @Test
    void getLoginInfo() {
    }
}