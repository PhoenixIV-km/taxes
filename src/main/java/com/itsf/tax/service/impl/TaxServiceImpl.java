package com.itsf.tax.service.impl;

import com.itsf.tax.config.TaxProperties;
import com.itsf.tax.item.Item;
import com.itsf.tax.service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxServiceImpl implements TaxService {

    private final TaxProperties taxProperties;

    @Override
    public String generateReceipt(List<Item> itemList) {
        final var result = new StringBuilder();
        var totalTaxes = new BigDecimal(0);
        var totalGlobal = new BigDecimal(0);

        // each item line
        for (final var item : itemList) {
            final var tax = item.computeTaxes(taxProperties.getBasicRate(), taxProperties.getImportRate(), taxProperties.getRoundingPrecision());
            final var itemTaxedPrice = item.getPrice().add(tax).multiply(new BigDecimal(item.getQuantity()));
            totalTaxes = totalTaxes.add(tax);
            totalGlobal = totalGlobal.add(itemTaxedPrice);
            result.append(item.getQuantity())
                    .append(item.isImported() ? " imported " : " ")
                    .append(item.getName())
                    .append(" : ")
                    .append(itemTaxedPrice)
                    .append("<br/>");
        }

        // summary line
        result.append("Sales Taxes : ")
                .append(totalTaxes)
                .append(" Total : ")
                .append(totalGlobal);

        return result.toString();
    }
}
