/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Item;

/**
 *
 * @author stein
 */
public class Item_dto {

    private Long itemid;
    private String name;
    private int PricePrKg;

    public Item_dto(Item item) {
        this.itemid = item.getItemid();
        this.name = item.getName();
        this.PricePrKg = item.getPricePrKg();
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePrKg() {
        return PricePrKg;
    }

    public void setPricePrKg(int PricePrKg) {
        this.PricePrKg = PricePrKg;
    }

    @Override
    public String toString() {
        return "Item_dto{" + "itemid=" + itemid + ", name=" + name + ", PricePrKg=" + PricePrKg + '}';
    }

}
