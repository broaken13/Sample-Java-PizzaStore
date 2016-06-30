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

// I am adding a comment here
public class Coupon {
    private int id;
    private String couponCode;
    private int discountAmount;
    private char discountType;
    private int quantity;
    
    private int itemId;
    private MenuItemSize item = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public char getDiscountType() {
        return discountType;
    }

    public void setDiscountType(char discountType) {
        this.discountType = discountType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public MenuItemSize getItem() {
        return item;
    }

    public void setItem(MenuItemSize item) {
        this.item = item;
    }
    
}
