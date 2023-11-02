package com.inspirecook.recipes.service;

import com.inspirecook.recipes.dto.RecipeDTO;
import com.inspirecook.recipes.entity.Recipe;

import java.util.List;

public interface RecipeService {
    void addRecipe(RecipeDTO recipeDTO);
    List<Recipe> getAll();

    Recipe getByName(String name);

    void updateRecipe(String recipeName, RecipeDTO recipeDTO);
}
