package com.inspirecook.recipes.controller;

import com.inspirecook.recipes.dto.RecipeDTO;
import com.inspirecook.recipes.entity.Recipe;
import com.inspirecook.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/add")
    public void addRecipe(@RequestBody RecipeDTO recipe) {
        recipeService.addRecipe(recipe);
    }

    @GetMapping("/getAll")
    public List<Recipe> getRecipes() {
        return recipeService.getAll();
    }

    @GetMapping("/getByName")
    public Recipe getRecipesByName(@RequestParam("name") String name) {
        return recipeService.getByName(name);
    }
}
