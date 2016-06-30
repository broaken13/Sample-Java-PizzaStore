/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.controllers;

import com.bryson.pizzadelivery.dataaccess.CustomerDAO;
import com.bryson.pizzadelivery.models.Customer;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bjo
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/Customers/*"})
public class CustomerController extends HttpServlet {

    
    private String[] getUrlParts(HttpServletRequest request) {
        String[] urlParts = request.getRequestURI().split(request.getServletPath());
        if (urlParts.length > 1) {
            return urlParts[1].replaceAll("^/+|/+$", "").split("/");
        } else {
            return new String[0];
        }
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String[] urlParts = getUrlParts(request);
        response.setContentType("application/json");
        String json = "";
        
        if(urlParts.length == 0 || urlParts[0].equals("")) {
            json = getAllCustomersAsJson();
            response.getWriter().write(json);
        } else if (urlParts.length < 2) {
            try {
                json = getSingleCustomerAsJson(urlParts[0]);
                response.getWriter().write(json);
            } catch (IllegalArgumentException e) {
                response.sendError(HttpURLConnection.HTTP_NOT_FOUND);
            } catch (Exception e) {
                response.sendError(HttpURLConnection.HTTP_INTERNAL_ERROR);
                e.printStackTrace();
            }
        }
        
    }
    
    private String getAllCustomersAsJson() throws IOException {
        ArrayList<Customer> custs = CustomerDAO.getAllCustomers();
        Gson gson = new Gson();
        return gson.toJson(custs);       
    }
    
    private String getSingleCustomerAsJson(String identifier) throws IllegalArgumentException, Exception {
        Gson gson = new Gson();
        Customer c = CustomerDAO.getSingleCustomer(identifier);
        return gson.toJson(c);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
