package com.example.marketplace.model;

import java.util.Arrays;

public class ShoppingItem {
    private Product product;
    private int[] buyers;

    public ShoppingItem(Product product) {
        this.product = product;
        buyers = new int[3];
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int[] getBuyers() { return buyers; }

    public void setBuyers(int[] buyers) { this.buyers = buyers; }

    public void printBuyers(int[] buyers) {
        System.out.println(Arrays.toString(buyers));
    }
}
