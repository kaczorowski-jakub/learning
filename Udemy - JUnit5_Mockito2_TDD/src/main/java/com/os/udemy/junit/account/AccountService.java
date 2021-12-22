package com.os.udemy.junit.account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {

    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    List<Account> getAllActiveAccounts() {
        return accountRepo.getAllAccounts().stream().filter(Account::isActive).collect(Collectors.toList());
    }

    List<String> findByName(String name) {
        return accountRepo.getByName(name);
    }
}
