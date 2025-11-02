package com.itsf.tax.item;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.utils.RoundingUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public abstract class Item {

    private final ItemType type;
    private final BigDecimal price;
    private final String name;
    private final boolean imported;
    private final Integer quantity;

    /**
     * Taxes are rounded up to nearest precision @see application.properties#tax.rounding-precision
     */
    public BigDecimal computeTaxes(final BigDecimal basicRate, final BigDecimal importRate, final BigDecimal roundingPrecision) {
        return RoundingUtils.roundingUpToNearestPrecision(getPrice().multiply(getApplicableTaxRate(basicRate, importRate)), roundingPrecision);
    }

    protected abstract BigDecimal getApplicableTaxRate(BigDecimal basicRate, BigDecimal importRate);
}
