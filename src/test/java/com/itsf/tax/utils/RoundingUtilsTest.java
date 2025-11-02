package com.itsf.tax.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class RoundingUtilsTest {

    @Test
    void roundingUpToNearestPrecisionTestNominal() {
        assertEquals(new BigDecimal("4.25"), (RoundingUtils.roundingUpToNearestPrecision(new BigDecimal("4.242"), new BigDecimal("0.05"))));
        assertEquals(new BigDecimal("4.25"), (RoundingUtils.roundingUpToNearestPrecision(new BigDecimal("4.2499999"), new BigDecimal("0.05"))));
        assertEquals(new BigDecimal("4.25"), (RoundingUtils.roundingUpToNearestPrecision(new BigDecimal("4.2400001"), new BigDecimal("0.05"))));
        assertEquals(new BigDecimal("4.25"), (RoundingUtils.roundingUpToNearestPrecision(new BigDecimal("4.25"), new BigDecimal("0.05"))));
    }

    @Test
    void roundingUpToNearestPrecisionTestOtherRoundingPrecisions() {
        assertEquals(new BigDecimal("5"), (RoundingUtils.roundingUpToNearestPrecision(new BigDecimal("4.25"), new BigDecimal("1"))));
        assertEquals(new BigDecimal("4.26"), (RoundingUtils.roundingUpToNearestPrecision(new BigDecimal("4.254"), new BigDecimal("0.01"))));
    }

    @Test
    void roundingUpToNearestPrecisionTestIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RoundingUtils.roundingUpToNearestPrecision(new BigDecimal("4.254"), new BigDecimal("-1")));
        assertThrows(IllegalArgumentException.class, () -> RoundingUtils.roundingUpToNearestPrecision(new BigDecimal("-1"), new BigDecimal("0.01")));
    }
}
