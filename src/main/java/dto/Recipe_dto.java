/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Recipe;
import java.util.List;

/**
 *
 * @author stein
 */
public class Recipe_dto {

    private Long id;
    private String resName;
    private int preptime;
    private String direction;
    private List<Ingredient_dto> ingredientList_dto;

    public Recipe_dto(Recipe recipe) {
        this.id = recipe.getRecipeid();
        this.preptime = recipe.getPreptime();
        this.direction = recipe.getDirections();
        this.resName = recipe.getResName();
        recipe.getIngredientlist()
                .forEach((ingredient) -> {
                    this.ingredientList_dto.add(new Ingredient_dto(ingredient));
                });
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<Ingredient_dto> getIngredientList_dto() {
        return ingredientList_dto;
    }

    public void setIngredientList_dto(List<Ingredient_dto> ingredientList_dto) {
        this.ingredientList_dto = ingredientList_dto;
    }

    @Override
    public String toString() {
        return "Recipe_dto{" + "id=" + id + ", resName=" + resName + ", preptime=" + preptime + ", direction=" + direction + ", ingredientList_dto=" + ingredientList_dto + '}';
    }

}
