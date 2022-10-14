/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author georg
 */
@Entity
@Table(name = "saved_recipes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SavedRecipes.findAll", query = "SELECT s FROM SavedRecipes s"),
    @NamedQuery(name = "SavedRecipes.findBySavedRecipesId", query = "SELECT s FROM SavedRecipes s WHERE s.savedRecipesId = :savedRecipesId"),
    @NamedQuery(name = "SavedRecipes.findByPaidFor", query = "SELECT s FROM SavedRecipes s WHERE s.paidFor = :paidFor")})
public class SavedRecipes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "saved_recipes_id")
    private Integer savedRecipesId;
    @Column(name = "paid_for")
    private Boolean paidFor;
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Recipe recipeId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User userId;

    public SavedRecipes() {
    }

    public SavedRecipes(Integer savedRecipesId) {
        this.savedRecipesId = savedRecipesId;
    }

    public Integer getSavedRecipesId() {
        return savedRecipesId;
    }

    public void setSavedRecipesId(Integer savedRecipesId) {
        this.savedRecipesId = savedRecipesId;
    }

    public Boolean getPaidFor() {
        return paidFor;
    }

    public void setPaidFor(Boolean paidFor) {
        this.paidFor = paidFor;
    }

    public Recipe getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Recipe recipeId) {
        this.recipeId = recipeId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (savedRecipesId != null ? savedRecipesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SavedRecipes)) {
            return false;
        }
        SavedRecipes other = (SavedRecipes) object;
        if ((this.savedRecipesId == null && other.savedRecipesId != null) || (this.savedRecipesId != null && !this.savedRecipesId.equals(other.savedRecipesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.SavedRecipes[ savedRecipesId=" + savedRecipesId + " ]";
    }
    
}
