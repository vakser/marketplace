package com.example.marketplace.model;

public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private int moneyAmount;

    public int getId() {
        return customerID;
    }

    public void setId(int id) {
        this.customerID = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String city) {
        this.lastName = city;
    }

    public int getMoneyAmount() { return moneyAmount; }

    public void setMoneyAmount(int moneyAmount) { this.moneyAmount = moneyAmount; }

}
