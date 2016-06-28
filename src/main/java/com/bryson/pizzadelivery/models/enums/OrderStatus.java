/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.models.enums;

/**
 *
 * @author bjo
 */
public enum OrderStatus {
    RECEIVED("Received"),
    COMPLETE("Complete"),
    PREPARING("Preparing"),
    DELIVERING("Delivering");
    
    
    private final String display;
    
    
    OrderStatus(String display) {
        this.display = display;
    }
    
    public String display() {
        return display;
    }
}
