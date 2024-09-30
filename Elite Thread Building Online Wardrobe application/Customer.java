package com.EliteThreads.shoppingapp.model;

public class Customer extends User {
    private String address;

    public Customer(String username, String gender, int age, String address) {
        super(username, gender, age);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
