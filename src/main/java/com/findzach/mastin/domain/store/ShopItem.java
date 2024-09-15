package com.findzach.mastin.domain.store;

import com.findzach.mastin.domain.BaseEntity;
import jakarta.persistence.MappedSuperclass;

/**
 * @author Zach Smith
 * @since 9/15/2024
 */
@MappedSuperclass
public abstract class ShopItem extends BaseEntity {

    private String name;
    private String description;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
