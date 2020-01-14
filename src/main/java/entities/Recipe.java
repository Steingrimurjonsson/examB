/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.Ingredient_dto;
import dto.Recipe_dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author stein
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Recipe.all", query = "SELECT r FROM Recipe r")})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeid;
    private String resName;
    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredientlist;

    private int preptime;
    private String directions;
    @ManyToMany(mappedBy = "recipelist")
    private List<WeekMenuPlan> weekMenuPlans;

    public Recipe() {
        this.ingredientlist = new ArrayList();
        this.weekMenuPlans = new ArrayList();
    }

    public Recipe(String resName, int preptime, String directions) {
        this.resName = resName;
        this.ingredientlist = new ArrayList();
        this.directions = directions;
        this.weekMenuPlans = new ArrayList();
        this.preptime = preptime;
    }

    Recipe(Recipe_dto recipe) {
        this.ingredientlist = new ArrayList();
        this.weekMenuPlans = new ArrayList();
        this.resName = recipe.getResName();
        this.preptime = recipe.getPreptime();
        this.directions = recipe.getDirection();
          for (Ingredient_dto ingredient : recipe.getIngredientList_dto()) {
            this.ingredientlist.add(new Ingredient(ingredient));
        }
        
    }

    public List<Ingredient> getIngredientlist() {
        return ingredientlist;
    }

    public void setIngredientlist(List<Ingredient> ingredientlist) {
        this.ingredientlist = ingredientlist;
    }

    public List<WeekMenuPlan> getWeekMenuPlans() {
        return weekMenuPlans;
    }

    public void setWeekMenuPlans(List<WeekMenuPlan> weekMenuPlans) {
        this.weekMenuPlans = weekMenuPlans;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Long getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(Long recipeid) {
        this.recipeid = recipeid;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

}
