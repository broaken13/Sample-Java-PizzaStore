/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.models;

import java.util.ArrayList;

/**
 *
 * @author bjo
 */
public class MenuItem {
    private int id;
    private String itemName;
    private String description;
    
    private ArrayList<MenuItemSize> sizes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<MenuItemSize> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<MenuItemSize> sizes) {
        this.sizes = sizes;
    }
    
    
}
