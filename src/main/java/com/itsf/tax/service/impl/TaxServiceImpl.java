package com.itsf.tax.service.impl;

import com.itsf.tax.factory.item.Item;
import com.itsf.tax.service.TaxService;
import com.itsf.tax.utils.MathUtils;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TaxServiceImpl implements TaxService {

    @Override
    public String compute(List<Item> itemList) {
        final var result = new StringBuilder();
        var totalTaxes = new BigDecimal(0);
        var totalGlobal = new BigDecimal(0);

        // each item line
        for (final var item : itemList) {
            final var tax = item.computeTaxes();
            final var itemTaxedPrice = item.getPrice().add(tax).multiply(new BigDecimal(item.getQuantity()));
            totalTaxes = totalTaxes.add(tax);
            totalGlobal = totalGlobal.add(itemTaxedPrice);
            result.append(item.getQuantity())
                    .append(" ")
                    .append(item.isImported() ? "imported " : "")
                    .append(item.getName())
                    .append(" : ")
                    .append(MathUtils.formatPrice(itemTaxedPrice))
                    .append("<br/>");
        }

        // summary line
        result.append("Sales Taxes : ")
                .append(MathUtils.formatPrice(totalTaxes))
                .append(" Total : ")
                .append(MathUtils.formatPrice(totalGlobal));

        return result.toString();
    }
}
