package com.inspirecook.repository;

import com.inspirecook.entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, Long> {
    Optional<Recipe> findByName(String name);
}
