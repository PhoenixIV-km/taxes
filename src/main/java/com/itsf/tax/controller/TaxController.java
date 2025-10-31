package com.itsf.tax.controller;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.factory.ItemFactory;
import com.itsf.tax.item.Item;
import com.itsf.tax.service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.ArrayList;

@RestController
@RequestMapping("/tax")
@RequiredArgsConstructor
public class TaxController {

    public static final String BOX_OF_CHOCOLATE = "box of chocolates";
    public static final String BOTTLE_OF_PERFUME = "bottle of perfume";

    private final TaxService taxService;
    private final ItemFactory itemFactory;

    @GetMapping("/computeInput1")
    public String computeInput1() {
        final var itemList = new ArrayList<Item>();
        itemList.add(itemFactory.createItem(ItemType.BOOK, new BigDecimal("12.49"), "book", Boolean.FALSE, 1));
        itemList.add(itemFactory.createItem(ItemType.ENTERTAINMENT, new BigDecimal("14.99"), "music CD", Boolean.FALSE, 1));
        itemList.add(itemFactory.createItem(ItemType.FOOD, new BigDecimal("0.85"), "chocolate bar", Boolean.FALSE, 1));
        return taxService.generateReceipt(itemList);
    }

    @GetMapping("/computeInput2")
    public String computeInput2() {
        final var itemList = new ArrayList<Item>();
        itemList.add(itemFactory.createItem(ItemType.FOOD, new BigDecimal("10.00"), BOX_OF_CHOCOLATE, Boolean.TRUE, 1));
        itemList.add(itemFactory.createItem(ItemType.BEAUTY_PRODUCT, new BigDecimal("47.50"), BOTTLE_OF_PERFUME, Boolean.TRUE, 1));
        return taxService.generateReceipt(itemList);
    }

    @GetMapping("/computeInput3")
    public String computeInput3() {
        final var itemList = new ArrayList<Item>();
        itemList.add(itemFactory.createItem(ItemType.BEAUTY_PRODUCT, new BigDecimal("27.99"), BOTTLE_OF_PERFUME, Boolean.TRUE, 1));
        itemList.add(itemFactory.createItem(ItemType.BEAUTY_PRODUCT, new BigDecimal("18.99"), BOTTLE_OF_PERFUME, Boolean.FALSE, 1));
        itemList.add(itemFactory.createItem(ItemType.MEDICAL_PRODUCT, new BigDecimal("9.75"), "packet of headache pills", Boolean.FALSE, 1));
        itemList.add(itemFactory.createItem(ItemType.FOOD, new BigDecimal("11.25"), BOX_OF_CHOCOLATE, Boolean.TRUE, 1));
        return taxService.generateReceipt(itemList);
    }
}
