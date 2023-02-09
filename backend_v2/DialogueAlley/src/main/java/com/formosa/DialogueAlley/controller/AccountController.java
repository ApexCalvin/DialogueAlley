package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.repository.AccountRepository;
import com.formosa.DialogueAlley.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/account")
@CrossOrigin("http://localhost:3000")
public class AccountController {
    @Autowired
    AccountServices accountServices;
    //@Autowired
    AccountRepository accountRepository;

    @PostMapping("/add")
    public String addAccount(@RequestBody Account account) {
        accountServices.saveAccount(account);
        return "Account has been created.";
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountServices.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
        try {
            Account account = accountServices.getAccountById(id);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable Integer id) {
        try{
                accountServices.saveAccount(account);
                return new ResponseEntity<>(account, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAccountById(@PathVariable Integer id) {
        accountServices.deleteAccountById(id);
        return "Account "+id+" has been deleted.";
    }

//    public LoginReponseDTO getLoginInfo(@RequestBody LoginInfoDTO login) { //VERIFY/AUTHENTICATION
//        Account account = accountRepository.findAccountByUsername(login.username());
//
//        // Conditional for username existence
//
//        if(account.getPassword().equals(login.password())) {
//            account.setPassword(null);
//            return new LoginReponseDTO(account, "Login info received.");
//        }
//
//        return new LoginReponseDTO(null , "Failed to login");
//    }
}