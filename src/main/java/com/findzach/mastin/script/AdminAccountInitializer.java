package com.findzach.mastin.script;

import com.findzach.mastin.domain.store.food.FoodItem;
import com.findzach.mastin.domain.store.food.Measurement;
import com.findzach.mastin.domain.store.food.ingredient.Ingredient;
import com.findzach.mastin.domain.user.MastinUser;
import com.findzach.mastin.repository.FoodRepository;
import com.findzach.mastin.repository.IngredientRepository;
import com.findzach.mastin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AdminAccountInitializer {

    private final UserRepository userRepository;
    private final FoodRepository foodRepository;
    private final IngredientRepository ingredientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminAccountInitializer(UserRepository userRepository, FoodRepository foodRepository, IngredientRepository ingredientRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
        this.ingredientRepository = ingredientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner createAdminAccount() {
        return args -> {
            String encodedPassword = passwordEncoder.encode("adminpassword");
            MastinUser adminUser = new MastinUser(1L, "admin", encodedPassword, "ROLE_ADMIN");
            System.out.println("Admin user created with username: " + adminUser.getUsername() + " and password: " + adminUser.getPassword());
            userRepository.save(adminUser);

            FoodItem foodItem = new FoodItem();
            foodItem.setName("Classic Pizza");
            foodItem.setDescription("Classic Pizza");
            foodItem.setPrice(12.99);

            Ingredient ingredient = new Ingredient();
            ingredient.setMeasurements(Arrays.asList(Measurement.TABLESPOON));
            ingredient.setName("Flour");
            ingredient.setDescription("Flour");
            ingredient.setPrice(.75);

            foodRepository.save(foodItem);
            ingredientRepository.save(ingredient);
        };
    }
}