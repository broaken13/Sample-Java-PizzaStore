/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.models;

import java.time.LocalTime;

/**
 *
 * @author bjo
 */
public class Location {
    private int id;
    private String address;
    private String phone;
    private LocalTime weekdayOpen;
    private LocalTime weekdayClose;
    private LocalTime weekendOpen;
    private LocalTime weekendClose;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalTime getWeekdayOpen() {
        return weekdayOpen;
    }

    public void setWeekdayOpen(LocalTime weekdayOpen) {
        this.weekdayOpen = weekdayOpen;
    }

    public LocalTime getWeekdayClose() {
        return weekdayClose;
    }

    public void setWeekdayClose(LocalTime weekdayClose) {
        this.weekdayClose = weekdayClose;
    }

    public LocalTime getWeekendOpen() {
        return weekendOpen;
    }

    public void setWeekendOpen(LocalTime weekendOpen) {
        this.weekendOpen = weekendOpen;
    }

    public LocalTime getWeekendClose() {
        return weekendClose;
    }

    public void setWeekendClose(LocalTime weekendClose) {
        this.weekendClose = weekendClose;
    }
    
    
}
