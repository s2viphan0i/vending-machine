package com.vendingmachine;

import com.vendingmachine.exception.InsufficientFundException;
import com.vendingmachine.exception.InvalidMoneyAmountException;
import com.vendingmachine.factory.ProductFactory;
import com.vendingmachine.logic.VendingMachineLogic;
import com.vendingmachine.model.Product;
import com.vendingmachine.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachineLogic vendingMachineLogic = new VendingMachineLogic();
        ProductFactory productFactory = new ProductFactory();
        try {
            System.out.println("======= Start Vending machine =======");
            System.out.print("Please insert your money: ");
            Long balance = scanner.nextLong();
            vendingMachineLogic.verifyBalance(balance);
            int choice = 0;
            List<Product> selectedProducts = new ArrayList<>();
            while (choice != 4 && choice != 5) {
                System.out.println("=============== Menu ===============");
                System.out.println("1.Coke: 10,000 VND\n2.Pepsi: 10,000 VND\n3.Soda: 20,000VND\n4.Done\n5.Refund");
                System.out.println("=============== Menu ===============");
                System.out.print("Please type your choice: ");
                choice = scanner.nextInt();
                Product product = productFactory.getProduct(choice);
                if (product != null) {
                    selectedProducts.add(product);
                }
            }
            if (selectedProducts.isEmpty() || choice == 5) {
                System.out.printf("Refunding cash: %s\n", NumberUtil.formatMoney(balance));
                return;
            }
            Long change = vendingMachineLogic.buyProduct(selectedProducts, balance);
            List<Long> changes = vendingMachineLogic.returnChange(change);
            System.out.printf("Successful buying%s, returning change: %s\n", vendingMachineLogic.getProductString(selectedProducts), NumberUtil.formatMoneyArray(changes));
        } catch (InvalidMoneyAmountException imae) {
            System.out.println("Invalid money amount!");
        } catch (InsufficientFundException ife) {
            System.out.println("Insufficient funds!");
        } catch (Exception ex) {
            System.out.println("Unknown error!");
        } finally {
            System.out.println("======== End Vending machine ========");
        }
    }
}
