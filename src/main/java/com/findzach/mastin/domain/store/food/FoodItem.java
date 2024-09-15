package com.findzach.mastin.domain.store.food;

import com.findzach.mastin.domain.store.food.ingredient.Ingredient;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class FoodItem extends ConsumableItem {

    @ManyToMany
    @JoinTable(
            name = "food_item_ingredients", // Name of the join table
            joinColumns = @JoinColumn(name = "food_item_id"), // Foreign key for FoodItem
            inverseJoinColumns = @JoinColumn(name = "ingredient_id") // Foreign key for Ingredient
    )
    private List<Ingredient> ingredients;

    private String allergyList; // Stores allergies as a comma-separated string

    // Getters and setters
    public String getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(String allergyList) {
        this.allergyList = allergyList;
    }

    // Utility method to get List<FoodAllergy>
    @Transient
    public List<FoodAllergy> getAllergies() {
        return Arrays.stream(allergyList.split(","))
                .map(FoodAllergy::valueOf)
                .collect(Collectors.toList());
    }

    // Utility method to set List<FoodAllergy>
    public void setAllergies(List<FoodAllergy> allergies) {
        this.allergyList = allergies.stream()
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}