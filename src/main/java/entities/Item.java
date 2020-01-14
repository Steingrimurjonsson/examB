/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.Item_dto;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author stein
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Item.all", query = "SELECT i FROM Storage i")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemid;
    private String name;
    private int pricePrKg;

    public Item(String name, int pricePrKg) {
        this.name = name;
        this.pricePrKg = pricePrKg;
    }

    public Item(Item_dto item_dto) {
        this.itemid = item_dto.getItemid();
        this.name = item_dto.getName();
        this.pricePrKg = item_dto.getPricePrKg();
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
        return pricePrKg;
    }

    public void setPricePrKg(int pricePrKg) {
        this.pricePrKg = pricePrKg;
    }

    @Override
    public String toString() {
        return "Item{" + "itemid=" + itemid + ", name=" + name + ", pricePrKg=" + pricePrKg + '}';
    }

}
