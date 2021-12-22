package com.os.udemy.junit.account;

import java.util.List;

public interface AccountRepo {
    List<Account> getAllAccounts();
    List<String> getByName(String name);
}
