package com.findzach.mastin.domain.store.food;

public enum Measurement {
    TEASPOON("tsp"),
    TABLESPOON("tbsp"),
    CUP("cup"),
    PINT("pt"),
    QUART("qt"),
    GALLON("gal"),
    OUNCE("oz"),
    POUND("lb"),
    GRAM("g"),
    KILOGRAM("kg"),
    LITER("l"),
    MILLILITER("ml");

    private final String abbreviation;

    Measurement(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
