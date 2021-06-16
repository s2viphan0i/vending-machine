package com.vendingmachine.model;

public class Soda implements Product {
    @Override
    public Long getPrice() {
        return 20000L;
    }

    @Override
    public String getName() {
        return "soda";
    }
}
