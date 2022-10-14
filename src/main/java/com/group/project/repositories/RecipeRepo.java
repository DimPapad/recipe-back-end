/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.repositories;

import com.group.project.models.Recipe;
import com.group.project.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author akisk
 */

public interface RecipeRepo extends JpaRepository<Recipe, Integer>  {
    
    List<Recipe> findByOwnerIdAndTypeAndNameContainsIgnoreCase(User User,String type,String name);
    List<Recipe> findAllByType(String type);
    List<Recipe> findAllByPaid(boolean b);
    List<Recipe> findByNameContainsIgnoreCaseAndType(String string,String type);
    List<Recipe> findByOwnerId(User User);
    List<Recipe> findByOwnerIdAndNameContainsIgnoreCase(User User, String name);
}
