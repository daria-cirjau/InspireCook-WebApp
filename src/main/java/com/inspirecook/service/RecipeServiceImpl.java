package com.inspirecook.service;

import com.inspirecook.dto.RecipeDTO;
import com.inspirecook.entity.Recipe;
import com.inspirecook.repository.RecipeRepository;
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

}
