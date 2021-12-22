package com.os.udemy.junit.account;

import java.util.Arrays;
import java.util.List;

public class AccountRepositoryStub implements AccountRepo {
    @Override
    public List<Account> getAllAccounts() {
        Address add1 = new Address("Kwiatowa", "33/5");
        Account account1 = new Account(add1);

        Account account2 = new Account();

        Address add2 = new Address("Piekarska", "12B");
        Account account3 = new Account(add2);

        return Arrays.asList(account1, account2, account3);
    }

    @Override
    public List<String> getByName(String name) {
        return null;
    }
}
