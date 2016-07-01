/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.models;

import java.math.BigDecimal;
/**
 *
 * @author bjo
 */
public class MenuItemSize {
    private int id;
    private String sizeName;
    private BigDecimal sizePrice;
    
    private int itemId;
    private MenuItem menuItem = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public BigDecimal getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(BigDecimal sizePrice) {
        this.sizePrice = sizePrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    } 
    
}
