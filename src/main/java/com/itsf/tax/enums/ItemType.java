package com.itsf.tax.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ItemType {
    // taxless
    BOOK(false),
    FOOD(false),
    MEDICAL_PRODUCT(false),

    // taxed
    ENTERTAINMENT(true),
    BEAUTY_PRODUCT(true);

    private final boolean taxable;
}
