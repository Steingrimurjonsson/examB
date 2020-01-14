/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.Menu_dto;
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

/**
 *
 * @author stein
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "WMP.all", query = "SELECT m FROM WeekMenuPlan m")
})
public class WeekMenuPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuid;
    @ManyToMany
    private List<Recipe> recipelist;
    private int w;
    private int y;

    public WeekMenuPlan() {
        this.recipelist = new ArrayList();
    }

    public WeekMenuPlan(Menu_dto menu_dto) {
        this.recipelist = new ArrayList();

        menu_dto.getRecipelist().forEach((recipe) -> {
            this.recipelist.add(new Recipe(recipe));
        });

        this.w = menu_dto.getW();
        this.menuid = menu_dto.getMenuid();
        this.y = menu_dto.getY();
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public List<Recipe> getRecipelist() {
        return recipelist;
    }

    public void setRecipelist(List<Recipe> recipelist) {
        this.recipelist = recipelist;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "WeekMenuPlan{" + "menuid=" + menuid + ", recipelist=" + recipelist + ", y=" + y + ", y=" + y + '}';
    }

}
