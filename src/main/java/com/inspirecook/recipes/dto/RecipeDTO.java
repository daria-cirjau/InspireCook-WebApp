package com.inspirecook.recipes.dto;

import java.util.List;

public class RecipeDTO {
    private String name;
    private List<String> ingredients;
    private String description;
    private int prepareTime;

    public RecipeDTO(String name, List<String> ingredients, String description, int prepareTime) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.prepareTime = prepareTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(int prepareTime) {
        this.prepareTime = prepareTime;
    }
}
