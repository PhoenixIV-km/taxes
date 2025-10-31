package com.itsf.tax.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class RoundingUtilsTest {

	@Test
	void roundingUpToNearestFiveHundredthsTest() {
        assertEquals(new BigDecimal("4.25"), (RoundingUtils.roundingUpToNearestFiveHundredths(new BigDecimal("4.242"), new BigDecimal("0.05"))));
        assertEquals(new BigDecimal("4.25"), (RoundingUtils.roundingUpToNearestFiveHundredths(new BigDecimal("4.2499999"), new BigDecimal("0.05"))));
        assertEquals(new BigDecimal("4.25"), (RoundingUtils.roundingUpToNearestFiveHundredths(new BigDecimal("4.2400001"), new BigDecimal("0.05"))));
        assertEquals(new BigDecimal("4.25"), (RoundingUtils.roundingUpToNearestFiveHundredths(new BigDecimal("4.25"), new BigDecimal("0.05"))));

        assertEquals(new BigDecimal("5"), (RoundingUtils.roundingUpToNearestFiveHundredths(new BigDecimal("4.25"), new BigDecimal("1"))));
        assertEquals(new BigDecimal("4.26"), (RoundingUtils.roundingUpToNearestFiveHundredths(new BigDecimal("4.254"), new BigDecimal("0.01"))));
        assertEquals(new BigDecimal("4.26"), (RoundingUtils.roundingUpToNearestFiveHundredths(new BigDecimal("4.254"), new BigDecimal("0.01"))));
        assertThrows(IllegalArgumentException.class, () -> RoundingUtils.roundingUpToNearestFiveHundredths(new BigDecimal("4.254"), new BigDecimal("-1")));
        assertThrows(IllegalArgumentException.class, () -> RoundingUtils.roundingUpToNearestFiveHundredths(new BigDecimal("-1"), new BigDecimal("0.01")));
	}
}
