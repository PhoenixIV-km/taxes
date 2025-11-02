package com.itsf.tax.factory.impl;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.factory.ItemFactory;
import com.itsf.tax.item.Item;
import com.itsf.tax.item.TaxedItem;
import com.itsf.tax.item.TaxlessItem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import java.math.BigDecimal;

@Component
@Validated
public class ItemFactoryImpl implements ItemFactory {

    @Override
    public Item createItem(final ItemType type, @Valid @NonNull final BigDecimal price, @NotBlank final String name, final boolean imported, @Min(1) final Integer quantity) {
        return type.isTaxable() ?
                new TaxedItem(type, price, name, imported, quantity)
                : new TaxlessItem(type, price, name, imported, quantity);
    }
}
