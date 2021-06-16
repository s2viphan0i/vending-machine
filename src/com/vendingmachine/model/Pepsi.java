package com.vendingmachine.model;

public class Pepsi implements Product {
    @Override
    public Long getPrice() {
        return 10000L;
    }

    @Override
    public String getName() {
        return "pepsi";
    }
}
