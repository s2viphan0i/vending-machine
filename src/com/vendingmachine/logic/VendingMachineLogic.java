package com.vendingmachine.logic;

import com.vendingmachine.constant.VendingMachineConstant;
import com.vendingmachine.exception.InsufficientFundException;
import com.vendingmachine.exception.InvalidMoneyAmountException;
import com.vendingmachine.model.Coke;
import com.vendingmachine.model.Pepsi;
import com.vendingmachine.model.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineLogic {
    public Long buyProduct(List<Product> products, Long balance) {
        Long price = products.stream().map(p -> p.getPrice())
                .reduce(0L, Long::sum);

        if (balance.compareTo(price) == -1) {
            throw new InsufficientFundException();
        }
        return balance - price;
    }

    public List<Long> returnChange(Long change) {
        List<Long> changes = new ArrayList<>();
        while (change > 0) {
            for (Long value : VendingMachineConstant.ACCEPTABLE_MONEY) {
                if (change % value == 0) {
                    changes.add(value);
                    change -= value;
                    break;
                }
            }
        }
        return changes;
    }

    public String getProductString(List<Product> products) {
        int cokeCount = 0;
        int pepsiCount = 0;
        int sodaCount = 0;
        for (Product product : products) {
            if (product instanceof Coke) {
                cokeCount++;
            } else if (product instanceof Pepsi) {
                pepsiCount++;
            } else {
                sodaCount++;
            }
        }

        return (cokeCount == 0 ? "" : " " + cokeCount + " coke") +
                (pepsiCount == 0 ? "" : " " + pepsiCount + " pepsi") +
                (sodaCount == 0 ? "" : " " + sodaCount + " soda");
    }

    public void verifyBalance(Long balance) {
        if (!VendingMachineConstant.ACCEPTABLE_MONEY.contains(balance)) {
            throw new InvalidMoneyAmountException();
        }
    }
}
