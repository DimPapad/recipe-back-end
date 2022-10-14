package com.group.project.controllers;

import com.group.project.models.Recipe;
import com.group.project.services.RecipeServiceInterface;
import com.group.project.services.SavedRecipesInterface;
import com.group.project.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/savedRecipes")
public class SavedRecipesController {

    @Autowired
    SavedRecipesInterface savedRecipesInterface;
    @Autowired
    RecipeServiceInterface recipeServiceInterface;
    @Autowired
    UserServiceInterface userServiceInterface;


    /*
    Creates a SavedRecipes obj and sets paidFor value 'true'.
     */
    @PostMapping("/buy/{userID}/{recipeID}")
    void buyRecipe(@PathVariable Integer userID, @PathVariable Integer recipeID) {
        savedRecipesInterface.buyRecipe(userID, recipeID);
    }

    /*
    Creates a SavedRecipes obj and sets paidFor value 'false'.
     */
    @PostMapping("/save/{userID}/{recipeID}")
    void saveRecipe(@PathVariable Integer userID, @PathVariable Integer recipeID) {
        savedRecipesInterface.saveRecipe(userServiceInterface.getUserById(userID), recipeServiceInterface.getRecipeById(recipeID));
    }

    /*
    Finds a SavedRecipes obj and sets paidFor value 'true'.
     */
    @PostMapping("/update/{userID}/{recipeID}")
    void setPaidForTrue(@PathVariable Integer userID, @PathVariable Integer recipeID) {
        savedRecipesInterface.setPaidForTrue(userID, recipeID);
    }

    /*
    Checks, if a SavedRecipes obj exists.
     */
    @GetMapping("/check/{userID}/{recipeID}")
    void check(@PathVariable Integer userID, @PathVariable Integer recipeID) {
        if (savedRecipesInterface.exists(userID, recipeID)) {
            savedRecipesInterface.setPaidForTrue(userID, recipeID);
        } else {
            savedRecipesInterface.saveRecipe(userServiceInterface.getUserById(userID), recipeServiceInterface.getRecipeById(recipeID));
            savedRecipesInterface.setPaidForTrue(userID, recipeID);
        }
    }

    @GetMapping("/exists/{userID}/{recipeID}")
    boolean exists(@PathVariable Integer userID, @PathVariable Integer recipeID) {
        return (savedRecipesInterface.exists(userID, recipeID));
    }

    @GetMapping("/show/{paidFor}/{userID}/{name}")
    List<Recipe> getRecipesByPaidForAndUserIDAndName(@PathVariable boolean paidFor, @PathVariable Integer userID, @PathVariable String name) {
        return savedRecipesInterface.getRecipesByUserIdAndPaidForAndName(userID, paidFor, name);
    }

    @GetMapping("/show/{paidFor}/{userID}")
    List<Recipe> getRecipesByPaidForAndUserID(@PathVariable boolean paidFor, @PathVariable Integer userID) {
        return savedRecipesInterface.getRecipesByUserIdAndPaidFor(userID, paidFor);
    }

    @GetMapping("/existsBought/{userID}/{recipeID}")
    boolean existsBought(@PathVariable Integer userID, @PathVariable Integer recipeID) {
        return (savedRecipesInterface.checkPaidFor(userID, recipeID));
    }
}