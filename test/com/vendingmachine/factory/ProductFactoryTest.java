package com.vendingmachine.factory;

import com.vendingmachine.exception.InvalidMoneyAmountException;
import com.vendingmachine.model.Coke;
import com.vendingmachine.model.Pepsi;
import com.vendingmachine.model.Product;
import com.vendingmachine.model.Soda;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class ProductFactoryTest {

    private ProductFactory productFactory;

    @Before
    public void setUp(){
        productFactory = new ProductFactory();
    }

    @Test
    public void test__getProduct__shouldSuccess__returnCoke(){
        Product coke = productFactory.getProduct(1);
        assertTrue(coke instanceof Coke);
    }

    @Test
    public void test__getProduct__shouldSuccess__returnPepsi(){
        Product pepsi = productFactory.getProduct(2);
        assertTrue(pepsi instanceof Pepsi);
    }

    @Test
    public void test__getProduct__shouldSuccess__returnSoda(){
        Product soda = productFactory.getProduct(3);
        assertTrue(soda instanceof Soda);
    }

    @Test
    public void test__getProduct__shouldSuccess__returnNull(){
        Product nullProduct = productFactory.getProduct(4);
        assertNull(nullProduct);
    }
}
