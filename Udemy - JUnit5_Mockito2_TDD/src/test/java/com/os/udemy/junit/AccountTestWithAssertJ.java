package com.os.udemy.junit;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTestWithAssertJ {

    @Test
    @DisplayName("New Account Should not be active")
    void newAccountShouldNotBeActiveAfterCreation() {
        // given + when
        Account account = new Account();

        // then
        assertFalse(account.isActive());
        assertThat(account.isActive()).isFalse();
    }

    @Test
    void accountShouldBeActiveAfterActivation() {
        // given
        Account account = new Account();

        // when
        account.activate();

        // then
        assertTrue(account.isActive());
        assertThat(account.isActive()).isTrue();
    }

    @Test
    void newlyCreatedAccountShouldNotHeaveDefaultDeliveryAddressSet() {
        // given
        Account account = new Account();

        // when
        Address address = account.getDefaultDeliveryAddress();

        // then
        assertNull(address);
        assertThat(address).isNull();
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
        assertThat(defaultAddress).isNotNull();
    }
}
