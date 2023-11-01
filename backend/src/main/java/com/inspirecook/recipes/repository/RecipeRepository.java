package com.inspirecook.recipes.repository;

import com.inspirecook.recipes.entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, Long> {
    Optional<Recipe> findByName(String name);
}
