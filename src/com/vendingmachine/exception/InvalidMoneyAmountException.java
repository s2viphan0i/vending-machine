package com.vendingmachine.exception;

public class InvalidMoneyAmountException extends RuntimeException {

    public InvalidMoneyAmountException() {
    }

    public InvalidMoneyAmountException(String message) {
        super(message);
    }

}
