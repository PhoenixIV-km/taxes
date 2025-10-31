package com.itsf.tax.item;

import com.itsf.tax.enums.ItemType;
import java.math.BigDecimal;

public class TaxlessItem extends Item {

    public TaxlessItem(final ItemType type, final BigDecimal price, final String name, final boolean imported, final Integer quantity) {
        super(type, price, name, imported, quantity);
    }

    @Override
    protected BigDecimal getApplicableTaxRate(final BigDecimal basicRate, final BigDecimal importRate) {
        return isImported() ? importRate : BigDecimal.ZERO;
    }
}
