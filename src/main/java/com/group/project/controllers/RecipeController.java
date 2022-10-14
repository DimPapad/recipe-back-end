/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.controllers;

import com.group.project.dto.RecipeDTO;
import com.group.project.models.Recipe;
import com.group.project.models.User;
import com.group.project.services.RecipeServiceInterface;
import com.group.project.services.UserServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author akisk
 */
@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeServiceInterface recipeServiceInterface;
    @Autowired
    UserServiceInterface userServiceInterface;

    /*
    Get All Recipes
     */
    @GetMapping("/all")
    List<Recipe> getAllRecipes() {
        return recipeServiceInterface.showAllRecipe();
    }

    /*
    Create a Recipe
     */
    @PostMapping("/")
    Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeServiceInterface.createRecipe(recipe);
    }

    /*
    Read a Recipe
     */
//    @GetMapping("/owned/{id}")
//    Recipe getRecipeById(@PathVariable Integer id) {
//        return recipeServiceInterface.getRecipeById(id);
//    }

    /*
    Update a Recipe
     */
    @PutMapping("/{id}")
    Recipe updateRecipeById(@PathVariable Integer id, @RequestBody Recipe recipe) {
        return recipeServiceInterface.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    void deleteRecipeById(@PathVariable Integer id) {
        recipeServiceInterface.deleteRecipe(id);
    }

    @GetMapping("/bought/{id}")
    public List<RecipeDTO> showAllBoughtRecipesByLoggedInUserId(@PathVariable(value = "id") User user) {
//        List<RecipeDTO> boughtRecipesByUserXDataOnly = new ArrayList();
        return recipeServiceInterface.getAllBoughtRecipesByLoggedInUserUsefulDataOnly(user);
//        boughtService.getAllBoughtRecipesByLoggedInUser(user).forEach(recipe -> boughtRecipesByUserXDataOnly.add(recipe));
//        return boughtRecipesByUserXDataOnly;

    }

    /*
    Search Recipe by Recipe Type.
     */
    @GetMapping("/search/{type}")
    public List<Recipe> showAllRecipesByType(@PathVariable(value = "type") String type){
        return recipeServiceInterface.showAllRecipesByType(type);
    }
    //to id einai to OwenerID

    @GetMapping("/owned/{owner_id}/{type}/{name}")
    public List<Recipe> showAllRecipesByOwnerIdAndTypeAndName(@PathVariable(value = "owner_id") Integer owner_id,@PathVariable(value = "name") String name,@PathVariable(value = "type") String type){
        return recipeServiceInterface.showAllRecipesByOwnerId(userServiceInterface.getUserById(owner_id),name,type);
    }
    //Search by Name and Type
    @GetMapping("/search/{type}/{name}")
    public List<Recipe> showAllRecipesContainsIgnoreCase(@PathVariable(value = "name") String name,@PathVariable(value = "type") String type){
        return recipeServiceInterface.showAllByNameContainsIgnoreCaseAndType(name, type);
    }


    @GetMapping("/owned/{owner_id}")
    public List<Recipe> showAllRecipesByOwnerId(@PathVariable(value = "owner_id") Integer owner_id){
        return recipeServiceInterface.showAllRecipesByOwner(userServiceInterface.getUserById(owner_id));
    }

    @GetMapping("/owned/{owner_id}/{name}")
    public List<Recipe> showAllRecipesByOwnerIdAndName(@PathVariable(value = "owner_id") Integer owner_id,@PathVariable(value = "name") String name){
        return recipeServiceInterface.showAllRecipesByOwnerAndName(userServiceInterface.getUserById(owner_id),name);
    }

}
