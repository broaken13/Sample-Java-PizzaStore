/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.models;

import com.bryson.pizzadelivery.models.enums.OrderStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author bjo
 */
public class Order {
    private int id;
    private LocalDateTime dateOrdered;
    private OrderStatus status;
    
    private int customerId;
    private Customer customer = null;
    
    private int locationId;
    private Location handlingLocation = null;
    
    private int couponId;
    private Coupon coupon = null;
    
    private ArrayList<OrderContent> contents = null;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDateTime dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Location getHandlingLocation() {
        return handlingLocation;
    }

    public void setHandlingLocation(Location handlingLocation) {
        this.handlingLocation = handlingLocation;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public ArrayList<OrderContent> getContents() {
        return contents;
    }

    public void setContents(ArrayList<OrderContent> contents) {
        this.contents = contents;
    }
    
}
