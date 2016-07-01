/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.controllers;

import com.google.gson.Gson;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bjo
 */
public abstract class BaseController extends HttpServlet {

    protected final Gson gson = new Gson();

    /**
     *
     * @param request The request to process
     * @return An array of the url pieces after the controller. Slashes [/] get
     * trimmed
     */
    protected String[] getUrlParts(HttpServletRequest request) {
        String[] urlParts = request.getRequestURI().split(request.getServletPath());
        if (urlParts.length > 1) {
            return urlParts[1].replaceAll("^/+|/+$", "").split("/");
        } else {
            return new String[0];
        }
    }
}
