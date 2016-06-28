/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.models;

/**
 *
 * @author bjo
 */
public class OrderContent {
    private int id;
    private int quantity;
    
    private int orderId;
    private Order order = null;
    
    private int menuItemSizeId;
    private MenuItemSize menuItemSize = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getMenuItemSizeId() {
        return menuItemSizeId;
    }

    public void setMenuItemSizeId(int menuItemSizeId) {
        this.menuItemSizeId = menuItemSizeId;
    }

    public MenuItemSize getMenuItemSize() {
        return menuItemSize;
    }

    public void setMenuItemSize(MenuItemSize menuItemSize) {
        this.menuItemSize = menuItemSize;
    }
}
