/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.datnt.datbook.core.order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.datnt.datbook.core.account.AccountDTO;
import org.datnt.datbook.core.cart.Cart;
import org.datnt.datbook.core.food.FoodDTO;
import org.datnt.datbook.core.item.Item;
import org.datnt.datbook.utils.DBHelper;

/**
 *
 * @author datnt
 */
public class OrderDAO implements Serializable {
    
      public int getListAccountLength() {
        Connection con = null;  
        PreparedStatement stm = null;
        ResultSet rs = null;
        int length = 0;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                String sql = "SELECT COUNT(*) FROM dbo.Orders";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if(rs.next()) {
                   length =  rs.getInt(1);
                   return length + 1;
                }
             }
        } catch (Exception e) {
        }
        return length;
    }
        //get Account by user and password.
    
    
    public void makeOrder(AccountDTO account, Cart cart) throws SQLException {
        LocalDate curdate = LocalDate.now();
        String date = curdate.toString();
        int id = getListAccountLength();
        String orderId = "order0" + id;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        FoodDTO dto = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Insert Into dbo.Orders Values(?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, orderId);
                stm.setString(2, account.getId());
                stm.setDouble(3, cart.getTotalMoney());
                stm.setString(4, date);
                stm.executeUpdate();
                
                String sql1 = "Select top 1 OrderId from dbo.Orders order by OrderId desc";
                stm = con.prepareStatement(sql1);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String oid = rs.getString("OrderId");
                    for (Item item : cart.getItems()) {
                        String sql2 = "Insert Into dbo.OrderDetail values (?, ?, ?, ?)";
                        stm = con.prepareStatement(sql2);
                        stm.setString(1, oid);
                        stm.setString(2, item.getFood().getFoodId());
                        stm.setInt(3, item.getQuantity());
                        stm.setDouble(4, item.getPrice());
                    }
                }
                
                String sql3 = "Update dbo.Food set quantity = quantity - ? where FoodId = ? ";
                stm = con.prepareStatement(sql3);
                
             
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
    }
}
