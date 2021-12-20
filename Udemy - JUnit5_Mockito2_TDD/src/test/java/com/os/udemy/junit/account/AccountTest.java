package com.os.udemy.junit.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test
    @DisplayName("New Account Should not be active")
    void newAccountShouldNotBeActiveAfterCreation() {
        // given + when
        Account account = new Account();

        // then
        assertFalse(account.isActive());
        assertThat(account.isActive(), equalTo(false));
    }

    @Test
    void accountShouldBeActiveAfterActivation() {
        // given
        Account account = new Account();

        // when
        account.activate();

        // then
        assertTrue(account.isActive());
        assertThat(account.isActive(), is(true));
    }

    @Test
    void newlyCreatedAccountShouldNotHeaveDefaultDeliveryAddressSet() {
        // given
        Account account = new Account();

        // when
        Address address = account.getDefaultDeliveryAddress();

        // then
        assertNull(address);
        assertThat(address, nullValue());
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterAccountActivation() {
        // given
        Account account = new Account();

        // when
        account.activate();
        Address address = account.getDefaultDeliveryAddress();

        // then
        assertNotNull(address);
        Address defaultAddress = address;
        assertThat(defaultAddress, notNullValue()); // nice to read as a sentence
    }

    @RepeatedTest(5)
    void newAccountWithNotNullAddressShouldBeActive() {
        // given
        Address addr = new Address("Pulawska", "46/6");

        // when
        Account acc = new Account(addr);

        // then
        assumingThat(addr != null, () -> {
            assertTrue(acc.isActive());
        });

    }

    @Test
    void invalidEmailShouldThrowException() {
        // given
        Account account = new Account();

        // when + then;
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrong email"));
    }

    @Test
    void validEmailShouldBeStored() {
        // given
        Account account = new Account();
        final String email = "test@op.pl";

        // when
        account.setEmail(email);

        // then
        assertThat(account.getEmail(), is(email));
    }
}
