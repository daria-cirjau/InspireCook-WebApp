package com.inspirecook.recipes.entity;

import com.inspirecook.recipes.dto.RecipeDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.*;
import java.util.Base64;
import java.util.List;

@Document(collection = "recipes")
public class Recipe {
    @Id
    private String _id;
    private String name;
    private List<String> ingredients;
    private String description;
    private int prepareTime;
    private String picture;

    public Recipe(String name, List<String> ingredients, String description, int prepareTime, String picture) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.prepareTime = prepareTime;
        this.picture = picture;
    }

    public Recipe(RecipeDTO recipeDTO) {
        this.name = recipeDTO.getName();
        this.ingredients = recipeDTO.getIngredients();
        this.description = recipeDTO.getDescription();
        this.prepareTime = recipeDTO.getPrepareTime();
        this.picture = pictureToByteArr(recipeDTO.getPicture());
    }

    private String pictureToByteArr(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileInputStream.close();

            return Base64.getEncoder().encodeToString(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Recipe() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public void setPictureFromPath(String picturePath) {
        this.picture = pictureToByteArr(picturePath);
    }
}
