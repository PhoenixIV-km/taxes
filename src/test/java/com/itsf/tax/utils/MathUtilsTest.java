package com.itsf.tax.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class MathUtilsTest {

	@Test
	void roundingTest() {
        assertEquals(0, new BigDecimal("4.25").compareTo(MathUtils.rounding(new BigDecimal("4.242"))));
        assertEquals(0, new BigDecimal("4.25").compareTo(MathUtils.rounding(new BigDecimal("4.2499999"))));
        assertEquals(0, new BigDecimal("4.25").compareTo(MathUtils.rounding(new BigDecimal("4.2400001"))));
        assertEquals(0, new BigDecimal("4.25").compareTo(MathUtils.rounding(new BigDecimal("4.25"))));
	}

    @Test
    void formatPriceTest() {
        assertEquals("42.00", MathUtils.formatPrice(new BigDecimal("42")));
        assertEquals("42.40", MathUtils.formatPrice(new BigDecimal("42.4")));
        assertEquals("42.42", MathUtils.formatPrice(new BigDecimal("42.42")));
    }
}
