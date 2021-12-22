package com.os.udemy.junit.account;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.BDDMockito.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class AccountServiceTest {

    private List<Account> prepareAccountData() {
        Address add1 = new Address("Kwiatowa", "33/5");
        Account account1 = new Account(add1);

        Account account2 = new Account();

        Address add2 = new Address("Piekarska", "12B");
        Account account3 = new Account(add2);

        return Arrays.asList(account1, account2, account3);
    }

    @Test
    void getAllActiveAccounts() {
        // given
        List<Account> accountList = prepareAccountData();
        AccountRepo accountRepoMock = mock(AccountRepo.class);
        AccountService accountService = new AccountService(accountRepoMock);
        //when(accountRepoMock.getAllAccounts()).thenReturn(accountList);
        given(accountRepoMock.getAllAccounts()).willReturn(accountList);

        // when
        List<Account> accountListRes = accountService.getAllActiveAccounts();

        // then
        assertThat(accountListRes, hasSize(2));
    }

    @Test
    void getNoActiveAccounts() {
        // given
        AccountRepo accountRepoMock = mock(AccountRepo.class);
        AccountService accountService = new AccountService(accountRepoMock);
        given(accountRepoMock.getAllAccounts()).willReturn(Collections.emptyList());

        // when
        List<Account> accountListRes = accountService.getAllActiveAccounts();

        // then
        assertThat(accountListRes, hasSize(0));
    }

    @Test
    void getAccountsByName() {

        // given
        AccountRepo accountRepoMock = mock(AccountRepo.class);
        AccountService accountService = new AccountService(accountRepoMock);
        given(accountRepoMock.getByName("kuba")).willReturn(Collections.singletonList("nowak"));

        // when
        List<String> accountNames = accountService.findByName("kuba");

        // then
        assertThat(accountNames, Matchers.contains("nowak"));
    }

}
