package com.itsf.tax.utils;

import java.math.BigDecimal;
import java.util.Locale;

public class MathUtils {

    /**
     * Rounding up to nearest 0.05
     * e.g. with price = 4.242
     * 4.242 * 20 = 84.84
     * Math.ceil(848.4) = 85
     * 845 / 20 = 4.25
     */
    public static BigDecimal rounding(final BigDecimal price) {
        // multiplying by 20 allows to balance the 0.05
        final var tmp = price.multiply(new BigDecimal(20));

        // checking if price rounding is not needed (no decimal left)
        if (tmp.doubleValue() % 1 == 0) {
            return price;
        }
        return new BigDecimal(Math.ceil(tmp.doubleValue()) / 20);
    }

    /**
     * format price at 2 decimals
     */
    public static String formatPrice(final BigDecimal price) {
        return String.format(Locale.US, "%.2f", price);
    }
}
