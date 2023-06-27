/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.datnt.datbook.core.food;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.datnt.datbook.core.account.AccountDTO;
import org.datnt.datbook.utils.DBHelper;

/**
 *
 * @author datnt
 */
    public class FoodDAO implements Serializable {

    List<FoodDTO> listFood;

    public FoodDAO() {
        listFood = new ArrayList<FoodDTO>();
    }

    public List<FoodDTO> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        FoodDTO dto = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT foodId, foodName, foodQuantity, foodPrice, foodType, isDisable, image FROM dbo.Food ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String foodId = rs.getString("foodId");
                    String foodName = rs.getString("foodName");
                    int foodQuantity = rs.getInt("foodQuantity");
                    double foodPrice = rs.getDouble("foodPrice");
                    String foodType = rs.getString("foodType");
                    boolean isDisable = rs.getBoolean("isDisable");
                    String image = rs.getString("image");
                    dto = new FoodDTO(foodId, foodName, foodQuantity, foodPrice, foodType, isDisable, image);
                    listFood.add(dto);
                }
                return listFood;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    
     public List<FoodDTO> getDogFood() throws SQLException {
         listFood = new ArrayList<FoodDTO>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        FoodDTO dto = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT foodId, foodName, foodQuantity, foodPrice, foodType, isDisable, image FROM dbo.Food WHERE foodType = 'cho'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String foodId = rs.getString("foodId");
                    String foodName = rs.getString("foodName");
                    int foodQuantity = rs.getInt("foodQuantity");
                    double foodPrice = rs.getDouble("foodPrice");
                    String foodType = rs.getString("foodType");
                    boolean isDisable = rs.getBoolean("isDisable");
                    String image = rs.getString("image");
                    dto = new FoodDTO(foodId, foodName, foodQuantity, foodPrice, foodType, isDisable, image);
                    listFood.add(dto);
                }
                return listFood;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    public List<FoodDTO> getCatFood() throws SQLException {
        listFood = new ArrayList<FoodDTO>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        FoodDTO dto = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT foodId, foodName, foodQuantity, foodPrice, foodType, isDisable, image FROM dbo.Food WHERE foodType = 'meo'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String foodId = rs.getString("foodId");
                    String foodName = rs.getString("foodName");
                    int foodQuantity = rs.getInt("foodQuantity");
                    double foodPrice = rs.getDouble("foodPrice");
                    String foodType = rs.getString("foodType");
                    boolean isDisable = rs.getBoolean("isDisable");
                    String image = rs.getString("image");
                    dto = new FoodDTO(foodId, foodName, foodQuantity, foodPrice, foodType, isDisable, image);
                    listFood.add(dto);
                }
                return listFood;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public FoodDTO getFoodById(String id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        FoodDTO dto = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT foodId, foodName, foodQuantity, foodPrice, foodType, isDisable FROM dbo.Food "
                        + "WHERE foodId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String foodId = rs.getString("foodId");
                    String foodName = rs.getString("foodName");
                    int foodQuantity = rs.getInt("foodQuantity");
                    double foodPrice = rs.getDouble("foodPrice");
                    String foodType = rs.getString("foodType");
                    boolean isDisable = rs.getBoolean("isDisable");
                    String image = rs.getString("image");

                    dto = new FoodDTO(foodId, foodName, foodQuantity, foodPrice, foodType, isDisable, image);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
