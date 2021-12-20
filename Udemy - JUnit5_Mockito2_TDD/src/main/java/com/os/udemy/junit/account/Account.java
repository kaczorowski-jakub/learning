package com.os.udemy.junit.account;

class Account {
    private boolean active;
    private Address defaultDeliveryAddress;
    private String email;

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

    public Account() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
        this.defaultDeliveryAddress = new Address("Default Street", "12b");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            throw new IllegalArgumentException("Wrong email address" + email);
        }
        this.email = email;
    }

    public boolean isActive() {
        return this.active;
    }
}
