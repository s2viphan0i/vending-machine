package com.vendingmachine.logic;

import com.vendingmachine.exception.InsufficientFundException;
import com.vendingmachine.exception.InvalidMoneyAmountException;
import com.vendingmachine.model.Coke;
import com.vendingmachine.model.Pepsi;
import com.vendingmachine.model.Product;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VendingMachineLogicTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private VendingMachineLogic vendingMachineLogic;

    private List<Product> products = Arrays.asList(new Coke(), new Pepsi());

    private Long balance = 50000L;

    @Before
    public void setUp() throws Exception {
        vendingMachineLogic = new VendingMachineLogic();
    }

    @Test
    public void test__buyProduct__shouldSuccess() {
        Long change = vendingMachineLogic.buyProduct(products, balance);
        assertEquals(30000L, (long) change);
    }

    @Test
    public void test__buyProduct__shouldError__insufficientFund() {
        thrown.expect(InsufficientFundException.class);
        vendingMachineLogic.buyProduct(products, 10000L);
    }

    @Test
    public void test__returnChange__shouldSuccess() {
        List<Long> changes = vendingMachineLogic.returnChange(170000L);
        assertEquals(5, changes.size());
        assertEquals(10000L, (long) changes.get(0));
        assertEquals(20000L, (long) changes.get(2));
        assertEquals(100000L, (long) changes.get(4));
    }

    @Test
    public void test__getProductString__shouldSuccess() {
        String productString = vendingMachineLogic.getProductString(products);
        assertEquals(" 1 coke 1 pepsi", productString);
    }

    @Test
    public void test__verifyBalance__shouldSuccess(){
        vendingMachineLogic.verifyBalance(20000L);
    }

    @Test
    public void test__verifyBalance__shouldError__invalidMoneyAmount(){
        thrown.expect(InvalidMoneyAmountException.class);
        vendingMachineLogic.verifyBalance(15000L);
    }
}
