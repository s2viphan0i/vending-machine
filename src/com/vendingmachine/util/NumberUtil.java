package com.vendingmachine.util;

import java.util.List;

public class NumberUtil {
    public static String formatMoney(Long number) {
        return String.format("%,d VND", number);
    }

    public static String formatMoneyArray(List<Long> numbers) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        String prefix = "";
        for (Long number : numbers) {
            builder.append(prefix);
            prefix = ", ";
            builder.append(formatMoney(number));
        }
        builder.append("]");
        return builder.toString();
    }
}
