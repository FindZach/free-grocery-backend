package com.findzach.mastin.domain.store.food;

import com.findzach.mastin.domain.store.ShopItem;

public abstract class ConsumableItem extends ShopItem {

    // No-arg constructor
    public ConsumableItem() {
    }

    // All-arg constructor
    public ConsumableItem(String name, String description, double price) {
        setName(name);
        setDescription(description);
        setPrice(price);
    }

}