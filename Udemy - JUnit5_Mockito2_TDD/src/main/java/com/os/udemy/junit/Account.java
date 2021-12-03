package com.os.udemy.junit;

public class Account {
    private boolean active;
    private Address defaultDeliveryAddress;

    public Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    public Account(Address defaultDeliveryAddress) {
        if (defaultDeliveryAddress != null) {
            this.active = true;
        } else {
            this.active = false;
        }
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }

    public void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }

    public Account() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
        this.defaultDeliveryAddress = new Address("Default Street", "12b");
    }

    public boolean isActive() {
        return this.active;
    }
}
