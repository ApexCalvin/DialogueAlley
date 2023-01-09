package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServices {
    @Autowired
    AccountRepository accountRepository;

    public void saveAccount(Account account) { // POST/CREATE
        accountRepository.save(account);
    }

    public List<Account> getAllAccounts() { // GET/READ/PLURAL
        return accountRepository.findAll();
    }

    public Account getAccountById(Integer id) { // GET/READ/SINGULAR
        return accountRepository.findById(id).get();
    }

    public void deleteAccountById(Integer id) { // DELETE/DELETE
        accountRepository.deleteById(id);
    }
}