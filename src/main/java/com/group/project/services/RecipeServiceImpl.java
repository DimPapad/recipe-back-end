/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.services;

import com.group.project.dto.RecipeDTO;
import com.group.project.models.Recipe;
import com.group.project.models.User;
import com.group.project.repositories.BoughtRepo;
import com.group.project.repositories.RecipeRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeServiceInterface {

    @Autowired
    RecipeRepo recipeRepo;
    @Autowired
    BoughtRepo boughtRepo;

    @Override
    public Recipe createRecipe(Recipe r) {
        recipeRepo.save(r);
        return recipeRepo.findById(r.getId()).get();
    }

    @Override
    public Recipe getRecipeById(Integer id) {
        return recipeRepo.findById(id).get();
    }

    @Override
    public Recipe updateRecipe(Integer id, Recipe r) {
        Recipe updateRecipe = getRecipeById(id);
        updateRecipe.setName(r.getName());
        updateRecipe.setInstructions(r.getInstructions());
        updateRecipe.setUtensils(r.getUtensils());
        updateRecipe.setDescription(r.getDescription());
        updateRecipe.setPhoto(r.getPhoto());
        updateRecipe.setVideo(r.getVideo());
        updateRecipe.setType(r.getType());
        return recipeRepo.save(updateRecipe);
    }

    @Override
    public void deleteRecipe(Integer id) {
        recipeRepo.deleteById(id);
    }

    @Override
    public List<Recipe> showAllRecipe() {
        return recipeRepo.findAll().stream().peek(recipe -> recipe.getOwnerId().setPassword(null)).collect(Collectors.toList());
    }

    @Override
    public List<RecipeDTO> getAllBoughtRecipesByLoggedInUserUsefulDataOnly(User user) {
        int i = 0;
        List<RecipeDTO> boughtRecipesByUserXDataOnly = new ArrayList();
        List<Recipe> boughtRecipesByUserX = new ArrayList();
        boughtRepo.findAllByUserId(user).forEach(bought -> boughtRecipesByUserX.add(bought.getRecipeId()));
        for (Recipe recipe : boughtRecipesByUserX) {
            boughtRecipesByUserXDataOnly.add(new RecipeDTO());
            boughtRecipesByUserXDataOnly.get(i).setId(recipe.getId());
            boughtRecipesByUserXDataOnly.get(i).setName(recipe.getName());
            boughtRecipesByUserXDataOnly.get(i).setInstructions(recipe.getInstructions());
            boughtRecipesByUserXDataOnly.get(i).setInstructions(recipe.getInstructions());
            boughtRecipesByUserXDataOnly.get(i).setUtensils(recipe.getUtensils());
            boughtRecipesByUserXDataOnly.get(i).setDescription(recipe.getDescription());
            boughtRecipesByUserXDataOnly.get(i).setIngredients(recipe.getIngredients());
            boughtRecipesByUserXDataOnly.get(i).setPhoto(recipe.getPhoto());
            boughtRecipesByUserXDataOnly.get(i).setVideo(recipe.getVideo());
            boughtRecipesByUserXDataOnly.get(i).setType(recipe.getType());
            boughtRecipesByUserXDataOnly.get(i).setPaid(recipe.getPaid());
            i++;
        }
        return boughtRecipesByUserXDataOnly;
    }

    @Override
    public List<Recipe> showAllRecipesByOwnerId(User user, String name, String type) {
        return recipeRepo.findByOwnerIdAndTypeAndNameContainsIgnoreCase(user, type, name);
    }

    @Override
    public List<Recipe> showAllByNameContainsIgnoreCaseAndType(String string, String type) {
        return recipeRepo.findByNameContainsIgnoreCaseAndType(string, type);
    }

    @Override
    public List<Recipe> showAllRecipesByType(String type) {
        return recipeRepo.findAllByType(type);
    }

    @Override
    public List<Recipe> showAllRecipesByPaid(Boolean b) {
        return recipeRepo.findAllByPaid(b);
    }

    @Override
    public List<Recipe> showAllRecipesByOwner(User ownerID){
        return recipeRepo.findByOwnerId(ownerID);
    }

    @Override
    public List<Recipe> showAllRecipesByOwnerAndName(User ownerID, String name) {
        return recipeRepo.findByOwnerIdAndNameContainsIgnoreCase(ownerID, name);
    }


}
