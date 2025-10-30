package com.itsf.tax.factory.creator;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.factory.item.Item;
import java.math.BigDecimal;

public interface ItemFactory {

    /**
     * Create an item depending on its type
     * @return the item
     */
    Item createItem(final ItemType type, final BigDecimal price, final String name, final boolean imported, final Integer quantity);
}
