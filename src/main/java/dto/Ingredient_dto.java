/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Ingredient;

/**
 *
 * @author stein
 */
public class Ingredient_dto {

    private Long item_id;
    private int amount;
    private Recipe_dto recipe_dto;
    private Item_dto item_dto;

    public Ingredient_dto(Ingredient ingredient) {
        this.item_id = ingredient.getItem_id();
        this.amount = ingredient.getAmount();
        this.recipe_dto = new Recipe_dto(ingredient.getRecipe());
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Recipe_dto getRecipe_dto() {
        return recipe_dto;
    }

    public void setRecipe_dto(Recipe_dto recipe_dto) {
        this.recipe_dto = recipe_dto;
    }

    public Item_dto getItem_dto() {
        return item_dto;
    }

    public void setItem_dto(Item_dto item_dto) {
        this.item_dto = item_dto;
    }

    @Override
    public String toString() {
        return "Ingredient_dto{" + "item_id=" + item_id + ", amount=" + amount + ", recipe_dto=" + recipe_dto + ", item_dto=" + item_dto + '}';
    }

}
