package com.inspirecook.recipes.service;

import com.inspirecook.recipes.dto.RecipeDTO;
import com.inspirecook.recipes.entity.Recipe;
import com.inspirecook.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void addRecipe(RecipeDTO recipeDTO) {
        Recipe recipeToAdd = new Recipe(recipeDTO);
        recipeRepository.insert(recipeToAdd);
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getByName(String name) {
        Optional<Recipe> optionalRecipe = recipeRepository.findByName(name);

        if(optionalRecipe.isPresent())
            return optionalRecipe.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "recipe with name:" + name + " NOT FOUND!");
    }

    @Override
    public void updateRecipe(String recipeName, RecipeDTO recipeDTO) {
        Optional<Recipe> optionalRecipe = recipeRepository.findByName(recipeName);

        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            updateRecipeAttributes(recipe, recipeDTO);
            recipeRepository.save(recipe);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe name:" + recipeName + " NOT FOUND!");
        }
    }

    private void updateRecipeAttributes(Recipe recipe, RecipeDTO recipeDTO) {
        if (recipeDTO.getDescription() != null) {
            recipe.setDescription(recipeDTO.getDescription());
        }
        if (recipeDTO.getName() != null) {
            recipe.setName(recipeDTO.getName());
        }
        if (recipeDTO.getIngredients() != null) {
            recipe.setIngredients(recipeDTO.getIngredients());
        }
        if (recipeDTO.getPrepareTime() != null) {
            recipe.setPrepareTime(recipeDTO.getPrepareTime());
        }
        if (recipeDTO.getPicture() != null) {
            recipe.setPictureFromPath(recipeDTO.getPicture());
        }
    }

}
