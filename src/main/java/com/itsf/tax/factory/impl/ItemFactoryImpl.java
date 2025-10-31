package com.itsf.tax.factory.impl;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.factory.ItemFactory;
import com.itsf.tax.item.Item;
import com.itsf.tax.item.TaxedItem;
import com.itsf.tax.item.TaxlessItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ItemFactoryImpl implements ItemFactory {

    @Override
    public Item createItem(final ItemType type, final BigDecimal price, final String name, final boolean imported, final Integer quantity) {
        return switch (type) {
            case BOOK, FOOD, MEDICAL_PRODUCT -> new TaxlessItem(type, price, name, imported, quantity);
            default -> new TaxedItem(type, price, name, imported, quantity);
        };
    }
}
