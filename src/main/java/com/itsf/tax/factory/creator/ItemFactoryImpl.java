package com.itsf.tax.factory.creator;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.factory.item.Item;
import com.itsf.tax.factory.item.TaxedItem;
import com.itsf.tax.factory.item.TaxlessItem;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ItemFactoryImpl implements ItemFactory {

    @Override
    public Item createItem(final ItemType type, final BigDecimal price, final String name, final boolean imported, final Integer quantity) {
        return switch (type) {
            case BOOK, FOOD, MEDICAL_PRODUCT -> new TaxlessItem(type, price, name, imported, quantity);
            default -> new TaxedItem(type, price, name, imported, quantity);
        };
    }
}
