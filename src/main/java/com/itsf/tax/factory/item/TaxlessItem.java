package com.itsf.tax.factory.item;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.utils.MathUtils;
import java.math.BigDecimal;

public class TaxlessItem extends Item {

    public TaxlessItem(final ItemType type, final BigDecimal price, final String name, final boolean imported, final Integer quantity) {
        super(type, price, name, imported, quantity);
    }

    @Override
    public BigDecimal computeTaxes() {
        return isImported() ? MathUtils.rounding(getPrice().multiply(IMPORT_TAX_RATE)) : new BigDecimal(0);
    }
}
