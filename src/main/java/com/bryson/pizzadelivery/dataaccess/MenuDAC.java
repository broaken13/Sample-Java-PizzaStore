/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bryson.pizzadelivery.dataaccess;

import com.bryson.pizzadelivery.models.MenuItem;
import com.bryson.pizzadelivery.models.MenuItemSize;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author bjo
 */
public class MenuDAC {

    public static ArrayList<MenuItem> getAllMenuItems() throws SQLException {
        String query = "SELECT mi.id AS itemId, itemName, description, mis.id, sizeName, sizePrice "
                + "FROM MenuItem mi JOIN MenuItemSize mis ON mis.itemId = mi.id ORDER BY mi.id";
        ArrayList<MenuItem> list = new ArrayList<>();

        try (Statement statement = StatementProvider.getBasicStatement()) {
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                do {
                    MenuItem item = getMenuItemFromResults(rs);
                    list.add(item);
                } while (!rs.isAfterLast());
            }

            return list;
        }

    }

    private static MenuItem getMenuItemFromResults(ResultSet rs) throws SQLException {
        MenuItem item = new MenuItem();
        item.setId(rs.getInt("itemId"));
        item.setItemName(rs.getString("itemName"));
        item.setDescription(rs.getString("description"));

        ArrayList<MenuItemSize> sizes = new ArrayList<>();
        do {
            MenuItemSize size = getSizeFromResults(rs);
            sizes.add(size);
        } while (rs.next() && rs.getInt("itemId") == item.getId());
        
        item.setSizes(sizes);
        return item;
    }

    private static MenuItemSize getSizeFromResults(ResultSet rs) throws SQLException {
        MenuItemSize size = new MenuItemSize();
        size.setItemId(rs.getInt("itemId"));
        size.setId(rs.getInt("id"));
        size.setSizeName(rs.getString("sizeName").trim());
        size.setSizePrice(rs.getBigDecimal("sizePrice"));
        return size;
    }
}
