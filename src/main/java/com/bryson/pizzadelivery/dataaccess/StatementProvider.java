/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.dataaccess;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author bjo
 */
public class StatementProvider {

    private static Connection dbConnection;

    private StatementProvider() {
    }

    private static void checkConnection() throws NamingException, SQLException {
        if (dbConnection == null || !dbConnection.isValid(3)) {
            InitialContext context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("jdbc/Database");
            dbConnection = ds.getConnection();
            System.out.println("Connection Created @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }

    public static Statement getBasicStatement() {
        Statement statement = null;

        try {
            checkConnection();
            statement = dbConnection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement statement = null;

        try {
            checkConnection();
            statement = dbConnection.prepareStatement(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        
        return statement;
    }

}
