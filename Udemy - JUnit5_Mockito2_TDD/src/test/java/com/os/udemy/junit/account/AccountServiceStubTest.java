package com.os.udemy.junit.account;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;

import java.util.List;

class AccountServiceStubTest {

    @Test
    void getAllActiveAccounts() {
        // given
        AccountRepo accountRepoStub = new AccountRepositoryStub();
        AccountService accountService = new AccountService(accountRepoStub);

        // when
        List<Account> accountList = accountService.getAllActiveAccounts();

        // then
        assertThat(accountList, hasSize(2));
    }

}