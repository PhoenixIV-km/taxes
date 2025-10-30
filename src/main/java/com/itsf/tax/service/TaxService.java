package com.itsf.tax.service;

import com.itsf.tax.factory.item.Item;
import java.util.List;

public interface TaxService {

    /**
     * Compute the sales taxes of a list of items
     * @param items the list of items
     * @return receipt details with taxes
     */
    String compute(final List<Item> items);
}
