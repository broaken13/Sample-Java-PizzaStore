/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.controllers;

import com.bryson.pizzadelivery.dataaccess.CustomerDAC;
import com.bryson.pizzadelivery.models.Customer;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class CustomerController extends BaseController {

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
        String json;

        try {
            if (urlParts.length == 0 || urlParts[0].equals("")) {

                json = getAllCustomersAsJson();
                response.getWriter().write(json);

            } else if (urlParts.length < 2) {

                json = getSingleCustomerAsJson(urlParts[0]);
                response.getWriter().write(json);

            }
        } catch (IllegalArgumentException e) {
            response.sendError(HttpURLConnection.HTTP_NOT_FOUND);
        } catch (Exception e) {
            response.sendError(HttpURLConnection.HTTP_INTERNAL_ERROR);
            e.printStackTrace();
        }
    }

    private String getAllCustomersAsJson() throws Exception {
        ArrayList<Customer> custs = CustomerDAC.getAllCustomers();
        return gson.toJson(custs);
    }

    private String getSingleCustomerAsJson(String identifier) throws IllegalArgumentException, Exception {
        Customer c = CustomerDAC.getSingleCustomer(identifier);
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
        try {

            if (!request.getContentType().equals("application/json")) {
                response.sendError(HttpURLConnection.HTTP_UNSUPPORTED_TYPE);
            } else {
                postRequest(request, response);
            }

        } catch (JsonParseException e) {
            response.sendError(HttpURLConnection.HTTP_BAD_REQUEST, "Bad JSON");
        } catch (Exception e) {
            response.sendError(HttpURLConnection.HTTP_INTERNAL_ERROR);
            e.printStackTrace();
        }

    }

    private void postRequest(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, Exception {
        Customer newCustomer = gson.fromJson(request.getReader(), Customer.class);

        if (!validateCustomer(newCustomer)) {
            response.sendError(HttpURLConnection.HTTP_BAD_REQUEST, "Either necessary values were missing, or email is already used");
        } else {
            newCustomer = CustomerDAC.insertCustomer(newCustomer);
            response.setContentType("application/json");
            response.setStatus(HttpURLConnection.HTTP_CREATED);
            response.getWriter().write(gson.toJson(newCustomer));
        }
    }

    /**
     *
     * @param c Customer to be validated
     *
     * @return If the customer has the required fields and a unique email
     *
     * @throws SQLException There was some issue loading
     */
    private boolean validateCustomer(Customer c) throws SQLException {
        if (c != null && c.getEmail() != null) {
            boolean usedEmail = CustomerDAC.checkEmailIsUsed(c.getEmail());
            return c.getName() != null && c.getAddress() != null && !usedEmail;
        } else {
            return false;
        }
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
