package com.itsf.tax.factory;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.item.Item;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import java.math.BigDecimal;

public interface ItemFactory {

    /**
     * Create an item depending on its type
     * @return the item
     */
    Item createItem(final ItemType type, @Valid @NonNull final BigDecimal price, @NotBlank final String name, final boolean imported, @Min(1) final Integer quantity);
}
