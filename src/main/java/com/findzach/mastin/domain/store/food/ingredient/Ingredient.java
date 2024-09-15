package com.findzach.mastin.domain.store.food.ingredient;

import com.findzach.mastin.domain.store.food.ConsumableItem;
import com.findzach.mastin.domain.store.food.Measurement;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ingredient extends ConsumableItem {

    @ElementCollection(targetClass = Measurement.class)
    @CollectionTable(name = "ingredient_measurements", joinColumns = @JoinColumn(name = "ingredient_id"))
    @Enumerated(EnumType.STRING)
    private List<Measurement> measurements;

    private double measureAmount;

    public Ingredient() {
    }

    public Ingredient(String name, String description, double price, List<Measurement> measurements) {
        super(name, description, price);
        this.measurements = measurements;
    }

    // Getters and setters for measurements
    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public double getMeasureAmount() {
        return measureAmount;
    }

    public void setMeasureAmount(double measureAmount) {
        this.measureAmount = measureAmount;
    }
}
