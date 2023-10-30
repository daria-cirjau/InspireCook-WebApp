package com.inspirecook.service;

import com.inspirecook.dto.RecipeDTO;
import com.inspirecook.entity.Recipe;

import java.util.List;

public interface RecipeService {
    void addRecipe(RecipeDTO recipeDTO);
    List<Recipe> getAll();

    Recipe getByName(String name);
}
