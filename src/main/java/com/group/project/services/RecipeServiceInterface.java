/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.group.project.services;

import com.group.project.dto.RecipeDTO;
import com.group.project.models.Recipe;
import com.group.project.models.User;
import java.util.List;

/**
 *
 * @author akisk
 */
public interface RecipeServiceInterface {

    Recipe createRecipe(Recipe r);

    Recipe getRecipeById(Integer id);

    Recipe updateRecipe(Integer id, Recipe r);

    void deleteRecipe(Integer id);

    List<Recipe> showAllRecipe();

    public List<RecipeDTO> getAllBoughtRecipesByLoggedInUserUsefulDataOnly(User user);

    List<Recipe> showAllRecipesByType(String type);

    List<Recipe> showAllRecipesByOwnerId(User user, String name, String type);

    List<Recipe> showAllRecipesByPaid(Boolean b);

    List<Recipe> showAllByNameContainsIgnoreCaseAndType(String string, String type);

    List<Recipe> showAllRecipesByOwner(User ownerID);
    List<Recipe> showAllRecipesByOwnerAndName(User ownerID, String name);


}
