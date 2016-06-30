/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.dataaccess;

import java.util.ArrayList;
import com.bryson.pizzadelivery.models.*;
import java.sql.*;

/**
 *
 * @author bjo
 */
public class CustomerDAO {

    public static ArrayList<Customer> getAllCustomers() {
        String query = "SELECT * FROM Customer";
        ArrayList<Customer> customers = new ArrayList<>();

        try (Statement statement = StatementProvider.getBasicStatement()) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Customer c = createCustomerFromResultSet(rs);
                customers.add(c);
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    public static Customer getSingleCustomer(String identifier) throws IllegalArgumentException, Exception {
        Customer cust = null;
        String query = generateQueryFromIdentifier(identifier);
        
        PreparedStatement statement = StatementProvider.getPreparedStatement(query);

        try {
            if(query.contains("email")) {
                statement.setString(1, identifier);
            } else {
                int id = Integer.parseInt(identifier);
                statement.setInt(1, id);
            }
            
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                cust = createCustomerFromResultSet(rs);
            } else {
                throw new IllegalArgumentException();
            }
            
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return cust;
    }
    
    private static String generateQueryFromIdentifier(String identifier) {
        String query = "SELECT * FROM Customer WHERE holder = ?";
        
        try {
            int id = Integer.parseInt(identifier);
            query = query.replaceAll("holder", "id");
        } catch (NumberFormatException e) {
            query = query.replaceAll("holder", "email");
        }
        
        return query;
    }

    private static Customer createCustomerFromResultSet(ResultSet rs) throws SQLException {
        Customer cust = new Customer();

        cust.setId(rs.getInt("id"));
        cust.setEmail(rs.getString("email"));
        cust.setAddress(rs.getString("address"));
        cust.setName(rs.getString("name"));
        cust.setPhone(rs.getString("phone"));

        return cust;
    }
}
