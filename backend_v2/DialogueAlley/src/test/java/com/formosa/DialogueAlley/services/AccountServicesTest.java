package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServicesTest {
    @InjectMocks
    AccountServices accountServices = new AccountServices();
    @Mock
    AccountRepository accountRepository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveAccount() {
        Account account = new Account();
        when(accountRepository.save(any(Account.class))).thenReturn(account);
        accountServices.saveAccount(account);
        verify(accountRepository).save(account);
    }

    @Test
    void getAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        when(accountRepository.findAll()).thenReturn(accountList);
        accountServices.getAllAccounts();
        verify(accountRepository).findAll();
    }

    @Test
    void getAccountById() {
        Account account = new Account();
        when(accountRepository.findById(anyInt())).thenReturn(Optional.of((account)));
        accountServices.getAccountById(1);
        verify(accountRepository).findById(1);
    }

    @Test
    void deleteAccountById() {
        accountServices.deleteAccountById(1);
        verify(accountRepository).deleteById(1);
    }
}