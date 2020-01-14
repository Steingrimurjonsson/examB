/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.Storage_dto;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author stein
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Storage.all", query = "SELECT s FROM Storage s"),
    @NamedQuery(name = "Storage.update", query = "SELECT s FROM Storage s WHERE s.item = (SELECT u FROM Item u WHERE u.itemid = :itemid)")
})
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemid;
    private int amount;
    @OneToOne
    private Item item;

    public Storage() {
    }

    public Storage(int amount) {
        this.amount = amount;
    }

    public Storage(Storage_dto storage_dto) {
        this.amount = storage_dto.getAmount();
        this.item = new Item(storage_dto.getItem());
        this.itemid = storage_dto.getItemid();
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Storage{" + "itemid=" + itemid + ", amount=" + amount + '}';
    }

}
