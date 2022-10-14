/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author georg
 */
@Entity
@Table(name = "recipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findById", query = "SELECT r FROM Recipe r WHERE r.id = :id"),
    @NamedQuery(name = "Recipe.findByName", query = "SELECT r FROM Recipe r WHERE r.name = :name"),
    @NamedQuery(name = "Recipe.findByPhoto", query = "SELECT r FROM Recipe r WHERE r.photo = :photo"),
    @NamedQuery(name = "Recipe.findByVideo", query = "SELECT r FROM Recipe r WHERE r.video = :video"),
    @NamedQuery(name = "Recipe.findByType", query = "SELECT r FROM Recipe r WHERE r.type = :type"),
    @NamedQuery(name = "Recipe.findByPaid", query = "SELECT r FROM Recipe r WHERE r.paid = :paid")})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "instructions")
    private String instructions;
    @Lob
    @Column(name = "utensils")
    private String utensils;
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "photo")
    private String photo;
    @Column(name = "video")
    private String video;
    @Column(name = "type")
    private String type;
    @Column(name = "paid")
    private Boolean paid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipeId")
    @JsonIgnore
    private Set<SavedRecipes> savedRecipesSet;
    @OneToMany(mappedBy = "recipeId")
    @JsonIgnore
    private Set<Bought> boughtSet;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User ownerId;

    public Recipe() {
    }

    public Recipe(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getUtensils() {
        return utensils;
    }

    public void setUtensils(String utensils) {
        this.utensils = utensils;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @XmlTransient
    public Set<SavedRecipes> getSavedRecipesSet() {
        return savedRecipesSet;
    }

    public void setSavedRecipesSet(Set<SavedRecipes> savedRecipesSet) {
        this.savedRecipesSet = savedRecipesSet;
    }

    @XmlTransient
    public Set<Bought> getBoughtSet() {
        return boughtSet;
    }

    public void setBoughtSet(Set<Bought> boughtSet) {
        this.boughtSet = boughtSet;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.Recipe[ id=" + id + " ]";
    }
    
}
