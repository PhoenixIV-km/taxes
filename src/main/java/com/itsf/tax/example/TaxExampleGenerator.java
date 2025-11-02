package com.itsf.tax.example;

import com.itsf.tax.enums.ItemType;
import com.itsf.tax.factory.ItemFactory;
import com.itsf.tax.item.Item;
import lombok.experimental.UtilityClass;
import java.math.BigDecimal;
import java.util.List;

@UtilityClass
public class TaxExampleGenerator {

    public static final String BOX_OF_CHOCOLATE = "box of chocolates";
    public static final String BOTTLE_OF_PERFUME = "bottle of perfume";

    public static List<Item> generateExampleInput1(final ItemFactory itemFactory) {
        return List.of(
                itemFactory.createItem(ItemType.BOOK, new BigDecimal("12.49"), "book", false, 1),
                itemFactory.createItem(ItemType.ENTERTAINMENT, new BigDecimal("14.99"), "music CD", false, 1),
                itemFactory.createItem(ItemType.FOOD, new BigDecimal("0.85"), "chocolate bar", false, 1)
        );
    }

    public static List<Item> generateExampleInput2(final ItemFactory itemFactory) {
        return List.of(
                itemFactory.createItem(ItemType.FOOD, new BigDecimal("10.00"), BOX_OF_CHOCOLATE, true, 1),
                itemFactory.createItem(ItemType.BEAUTY_PRODUCT, new BigDecimal("47.50"), BOTTLE_OF_PERFUME, true, 1)
        );
    }

    public static List<Item> generateExampleInput3(final ItemFactory itemFactory) {
        return List.of(
                itemFactory.createItem(ItemType.BEAUTY_PRODUCT, new BigDecimal("27.99"), BOTTLE_OF_PERFUME, true, 1),
                itemFactory.createItem(ItemType.BEAUTY_PRODUCT, new BigDecimal("18.99"), BOTTLE_OF_PERFUME, false, 1),
                itemFactory.createItem(ItemType.MEDICAL_PRODUCT, new BigDecimal("9.75"), "packet of headache pills", false, 1),
                itemFactory.createItem(ItemType.FOOD, new BigDecimal("11.25"), BOX_OF_CHOCOLATE, true, 1)
        );
    }
}
