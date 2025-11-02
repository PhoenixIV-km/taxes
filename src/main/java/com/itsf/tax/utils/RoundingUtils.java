package com.itsf.tax.utils;

import lombok.experimental.UtilityClass;
import java.math.BigDecimal;
import java.math.RoundingMode;

@UtilityClass
public class RoundingUtils {

    /**
     * Implements tax rounding rule
     * e.g. with price = 42.42 and roundingPrecision = 0.05
     * 42.42 / 0.05 = 848.4
     * scale 0 and RoundingMode.UP(848.4) = 849
     * 849 * 0.05 = 42.45
     */
    public static BigDecimal roundingUpToNearestPrecision(final BigDecimal price, final BigDecimal roundingPrecision) {
        if (price.compareTo(new BigDecimal(0)) < 0 || roundingPrecision.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException("Price and roundingPrecision should be >= 0");
        }
        final var divided = price.divide(roundingPrecision, 0, RoundingMode.UP);
        return divided.multiply(roundingPrecision);
    }
}
