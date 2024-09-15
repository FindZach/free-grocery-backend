package com.findzach.mastin.repository;

import com.findzach.mastin.domain.store.food.ingredient.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zach Smith
 * @since 9/15/2024
 */
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
