package com.example.marketplace.model;

import java.util.Arrays;

public class ShoppingItem {
    private Product product;
    private Customer[] buyers;

    public ShoppingItem(Product product) {
        this.product = product;
        buyers = new Customer[3];
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer[] getBuyers() { return buyers; }

    public void setBuyers(Customer[] buyers) { this.buyers = buyers; }

    public void printBuyers(int[] buyers) {
        System.out.println(Arrays.toString(buyers));
    }
}
