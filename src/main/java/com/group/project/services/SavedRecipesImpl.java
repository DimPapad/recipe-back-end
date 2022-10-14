package com.group.project.services;

import com.group.project.models.Recipe;
import com.group.project.models.SavedRecipes;
import com.group.project.models.User;
import com.group.project.repositories.SavedRecipesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SavedRecipesImpl implements SavedRecipesInterface {

    @Autowired
    SavedRecipesRepo savedRecipesRepo;

    @Autowired
    UserServiceInterface userService;
    @Autowired
    RecipeServiceInterface recipeService;

    @Override
    public void saveRecipe(User userID, Recipe recipeID) {
        SavedRecipes sR = new SavedRecipes();
        sR.setRecipeId(recipeID);
        sR.setUserId(userID);
        sR.setPaidFor(false);
        savedRecipesRepo.save(sR);
    }

    @Override
    public void saveRecipe(SavedRecipes savedRecipes) {

        savedRecipesRepo.save(savedRecipes);
    }

    @Override
    public void setPaidForTrue(Integer userID, Integer recipeID){
        User user = userService.getUserById(userID);
        Recipe recipe = recipeService.getRecipeById(recipeID);
        SavedRecipes sR = savedRecipesRepo.findByUserIdAndRecipeId(user,recipe);
        sR.setPaidFor(true);
        savedRecipesRepo.save(sR);
    }

    @Override
    public boolean exists(Integer userID, Integer recipeID){
        User user = userService.getUserById(userID);
        Recipe recipe = recipeService.getRecipeById(recipeID);
        return (savedRecipesRepo.findByUserIdAndRecipeId(user, recipe) != null);
    }

    @Override
    public void buyRecipe(Integer userID, Integer recipeID){
        SavedRecipes sR = new SavedRecipes();
        sR.setPaidFor(true);
        sR.setRecipeId(recipeService.getRecipeById(recipeID));
        sR.setUserId(userService.getUserById(userID));
        savedRecipesRepo.save(sR);
    }

    @Override
    public List<Recipe> getRecipesByUserIdAndPaidForAndName(Integer userID, boolean paidFor, String name){
        List<Recipe> rL = new ArrayList<>();
        for (SavedRecipes sR: savedRecipesRepo.findByPaidForAndUserId(paidFor, userService.getUserById(userID))
             ) {
            rL.add(sR.getRecipeId());
        }
        return (rL.stream().filter(r->r.getName().equals(name)).collect(Collectors.toList()));
    }

    @Override
    public List<Recipe> getRecipesByUserIdAndPaidFor(Integer userID, boolean paidFor){
        List<Recipe> rL = new ArrayList<>();
        for (SavedRecipes sR: savedRecipesRepo.findByPaidForAndUserId(paidFor, userService.getUserById(userID))
        ) {
            rL.add(sR.getRecipeId());
        }
        return (rL);
    }

    @Override
    public boolean checkPaidFor(Integer userID, Integer recipeID){
        SavedRecipes sR = savedRecipesRepo.findByUserIdAndRecipeId(userService.getUserById(userID),recipeService.getRecipeById(recipeID));
    return ((sR != null && sR.getPaidFor()));
    }


}
