package com.itsf.tax.factory;

import static org.junit.jupiter.api.Assertions.*;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.item.TaxedItem;
import com.itsf.tax.item.TaxlessItem;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;

@SpringBootTest
public class ItemFactoryTest {

    public static final String ITEM_NAME = "trip ticket";
    public static final BigDecimal PRICE = new BigDecimal("42.42");
    public static final Integer QUANTITY = 4;

    @Autowired
    private ItemFactory itemFactory;

    @Test
    void createItemTestFields() {
        final var item = itemFactory.createItem(ItemType.ENTERTAINMENT, PRICE, ITEM_NAME, true, QUANTITY);
        assertEquals(ItemType.ENTERTAINMENT, item.getType());
        assertEquals(PRICE, item.getPrice());
        assertEquals(ITEM_NAME, item.getName());
        assertTrue(item.isImported());
        assertEquals(QUANTITY, item.getQuantity());
        assertTrue(item.getType().isTaxable());
    }

    @Test
    void createItemTestItemTaxed() {
        final var item = itemFactory.createItem(ItemType.ENTERTAINMENT, PRICE, ITEM_NAME, true, QUANTITY);
        assertInstanceOf(TaxedItem.class, item);
    }

    @Test
    void createItemTestItemTaxless() {
        final var item = itemFactory.createItem(ItemType.BOOK, PRICE, "da vince code", true, QUANTITY);
        assertInstanceOf(TaxlessItem.class, item);
    }

    @Test
    void createItemTestValidationErrors() {
        assertThrows(NullPointerException.class, () -> itemFactory.createItem(ItemType.ENTERTAINMENT, null, ITEM_NAME, true, QUANTITY));
        assertThrows(ConstraintViolationException.class, () -> itemFactory.createItem(ItemType.ENTERTAINMENT, PRICE, ITEM_NAME, true, -1));
        assertThrows(ConstraintViolationException.class, () -> itemFactory.createItem(ItemType.ENTERTAINMENT, PRICE, "", true, QUANTITY));
    }
}
