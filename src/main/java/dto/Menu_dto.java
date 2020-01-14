/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.WeekMenuPlan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stein
 */
public class Menu_dto {

    private Long menuid;
    private int w;
    private int y;
    private List<Recipe_dto> recipelist;

    public Menu_dto() {
        this.recipelist = new ArrayList();
    }

    public Menu_dto(WeekMenuPlan w) {
        this.menuid = w.getMenuid();
        this.w = w.getW();
        this.y = w.getY();
        this.recipelist = new ArrayList();
        w.getRecipelist().forEach((recipe) -> {
            this.recipelist.add(new Recipe_dto(recipe));
        });

    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
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

    public List<Recipe_dto> getRecipelist() {
        return recipelist;
    }

    public void setRecipelist(List<Recipe_dto> recipelist) {
        this.recipelist = recipelist;
    }

}
