package com.itsf.tax.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.itsf.tax.enums.ItemType;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class ItemTest {

    public static final BigDecimal BASIC_RATE = new BigDecimal("0.10");
    public static final BigDecimal IMPORT_RATE = new BigDecimal("0.05");
    public static final BigDecimal ROUNDING_PRECISION = new BigDecimal("0.05");

    @Test
    void computeTaxesTestItemTaxedAndImported() {
        final var taxedItem = new TaxedItem(ItemType.ENTERTAINMENT, new BigDecimal("42.42"), "concert ticket", true, 1);
        assertEquals(0, new BigDecimal("6.40").compareTo(taxedItem.computeTaxes(BASIC_RATE, IMPORT_RATE, ROUNDING_PRECISION)));
    }

    @Test
    void computeTaxesTestItemTaxedNotImported() {
        final var taxedItem = new TaxedItem(ItemType.ENTERTAINMENT, new BigDecimal("42.42"), "concert ticket", false, 1);
        assertEquals(0, new BigDecimal("4.25").compareTo(taxedItem.computeTaxes(BASIC_RATE, IMPORT_RATE, ROUNDING_PRECISION)));
    }

    @Test
    void computeTaxesTestItemTaxlessAndImported() {
        final var taxlessItem = new TaxlessItem(ItemType.BOOK, new BigDecimal("42.42"), "da vinci code", true, 1);
        assertEquals(0, new BigDecimal("2.15").compareTo(taxlessItem.computeTaxes(BASIC_RATE, IMPORT_RATE, ROUNDING_PRECISION)));
    }

    @Test
    void computeTaxesTestItemTaxlessNotImported() {
        final var taxlessItem = new TaxlessItem(ItemType.BOOK, new BigDecimal("42.42"), "da vinci code", false, 1);
        assertEquals(0, new BigDecimal("0").compareTo(taxlessItem.computeTaxes(BASIC_RATE, IMPORT_RATE, ROUNDING_PRECISION)));
    }
}
