package com.itsf.tax.factory.item;

import com.itsf.tax.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public abstract class Item {

    protected static final BigDecimal IMPORT_TAX_RATE = new BigDecimal("0.05"); // 5% taxes

    private ItemType type;
    private BigDecimal price;
    private String name;
    private boolean imported;
    private Integer quantity;

    public abstract BigDecimal computeTaxes();
}
