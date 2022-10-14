/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.project.repositories;

import com.group.project.models.Recipe;
import com.group.project.models.SavedRecipes;
import com.group.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author mhtso
 */
@Repository
public interface SavedRecipesRepo extends JpaRepository<SavedRecipes, Integer> {

    SavedRecipes findByUserIdAndRecipeId(User user, Recipe recipe);
    List<SavedRecipes> findByPaidForAndUserId(boolean paidFor, User userID);



}
