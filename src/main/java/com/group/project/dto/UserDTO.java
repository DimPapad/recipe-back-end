package com.group.project.dto;

import com.group.project.models.Bought;
import com.group.project.models.Recipe;
import com.group.project.models.SavedRecipes;
import java.util.Set;

/**
 *
 * @author mhtso
 */
public interface UserDTO {

    public Integer getId();

    public String getEmail();

    public String getName();

    public String getRole();

    public Set<SavedRecipes> getSavedRecipesSet();

    public Set<Bought> getBoughtSet();

    public Set<Recipe> getRecipeSet();

}
