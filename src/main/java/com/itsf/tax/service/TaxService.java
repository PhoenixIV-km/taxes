package com.itsf.tax.service;

import com.itsf.tax.item.Item;
import java.util.List;

public interface TaxService {

    /**
     * Generate the receipt for a list of items
     * @param itemList the list of items
     * @return receipt details with taxes and total
     */
    String generateReceipt(final List<Item> itemList);
}
