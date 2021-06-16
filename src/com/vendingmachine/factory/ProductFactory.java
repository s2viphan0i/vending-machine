package com.vendingmachine.factory;

import com.vendingmachine.constant.ProductTypeConstant;
import com.vendingmachine.model.Coke;
import com.vendingmachine.model.Pepsi;
import com.vendingmachine.model.Product;
import com.vendingmachine.model.Soda;

public class ProductFactory {
    public Product getProduct(int productType) {
        switch (productType) {
            case ProductTypeConstant.COKE_TYPE:
                return new Coke();
            case ProductTypeConstant.PEPSI_TYPE:
                return new Pepsi();
            case ProductTypeConstant.SODA_TYPE:
                return new Soda();
            default:
                return null;
        }
    }
}
