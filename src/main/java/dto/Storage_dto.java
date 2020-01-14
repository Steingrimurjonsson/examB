/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Storage;

/**
 *
 * @author stein
 */
public class Storage_dto {

    private Item_dto item;
    private Long itemid;
    private int amount;

    public Storage_dto(Item_dto item, Long itemid, int amount) {
        this.item = item;
        this.itemid = itemid;
        this.amount = amount;
    }

    public Storage_dto(Storage storage) {
        this.item = new Item_dto(storage.getItem());
        this.itemid = storage.getItemid();
        this.amount = storage.getAmount();
    }

    public Item_dto getItem() {
        return item;
    }

    public void setItem(Item_dto item) {
        this.item = item;
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Storage_dto{" + "item=" + item + ", itemid=" + itemid + ", amount=" + amount + '}';
    }

}
