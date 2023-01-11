package com.formosa.DialogueAlley.repository;

import com.formosa.DialogueAlley.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findAccountByHandle(String handle);
    Account findAccountByUsername(String username);
}
