package com.findzach.mastin.domain.store.food;

public enum FoodAllergy {
    PEANUT("Peanut"),
    LACTOSE("Lactose"),
    GLUTEN("Gluten"),
    SHELLFISH("Shellfish"),
    EGG("Egg"),
    SOY("Soy"),
    TREE_NUTS("Tree Nuts"),
    FISH("Fish"),
    SESAME("Sesame"),
    WHEAT("Wheat");

    private final String allergyName;

    FoodAllergy(String allergyName) {
        this.allergyName = allergyName;
    }

    public String getAllergyName() {
        return allergyName;
    }
}

