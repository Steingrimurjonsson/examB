/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.Ingredient_dto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author stein
 */
@Entity
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long item_id;
    private int amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne
    private Item item;

    public Ingredient() {
    }

    public Ingredient(int amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    public Ingredient(Ingredient_dto ingredient) {
        this.item_id = ingredient.getItem_id();
        this.item = new Item(ingredient.getItem_dto());
        this.amount = ingredient.getAmount();
    }

    public Recipe getRecipe() {
        return recipe;
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

    @Override
    public String toString() {
        return "Ingredient{" + "item_id=" + item_id + ", amount=" + amount + '}';
    }

    public void setRecipe(Recipe burgerFries) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
