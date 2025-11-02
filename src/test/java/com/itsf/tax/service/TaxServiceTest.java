package com.itsf.tax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.factory.ItemFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class TaxServiceTest {

    public static final String NAME = "ticket to Tokyo";
    public static final BigDecimal PRICE = new BigDecimal("42.42");

    @Autowired
    private TaxService taxService;
    @Autowired
    private ItemFactory itemFactory;

    @Test
    void generateReceiptTestTaxless() {
        final var result = taxService.generateReceipt(List.of(
                itemFactory.createItem(ItemType.FOOD, PRICE, "raclette set", false, 1)
        ));
        assertEquals("1 raclette set : 42.42<br/>Sales Taxes : 0.00 Total : 42.42", result);
    }

    @Test
    void generateReceiptTestTaxed() {
        final var result = taxService.generateReceipt(List.of(
                itemFactory.createItem(ItemType.ENTERTAINMENT, PRICE, NAME, false, 1)
        ));
        assertEquals("1 " + NAME + " : 46.67<br/>Sales Taxes : 4.25 Total : 46.67", result);
    }

    @Test
    void generateReceiptTestTaxedImported() {
        final var result = taxService.generateReceipt(List.of(
                itemFactory.createItem(ItemType.ENTERTAINMENT, PRICE, NAME, true, 1)
        ));
        assertEquals("1 imported " + NAME + " : 48.82<br/>Sales Taxes : 6.40 Total : 48.82", result);
    }
}
