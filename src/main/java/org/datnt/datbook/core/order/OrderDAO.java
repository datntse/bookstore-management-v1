/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.datnt.datbook.core.order;

import java.io.Serializable;
import static java.rmi.server.LogStream.log;
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
        PreparedStatement stm1 = null;
        PreparedStatement stm2 = null;
        PreparedStatement stm3 = null;
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
                int result = stm.executeUpdate();
                
                if (result > 0) {
                    log("Make order success");
                }
                
                String sql1 = "Select top 1 orderId from dbo.Orders order by orderId desc";
                stm1 = con.prepareStatement(sql1);
                rs = stm1.executeQuery();
                if (rs.next()) {
                    String oid = rs.getString("orderId");
                    for (Item item : cart.getItems()) {
                        String sql2 = "Insert Into dbo.Order_detail values (?, ?, ?, ?)";
                        stm2 = con.prepareStatement(sql2);
                        stm2.setString(1, oid);
                        stm2.setString(2, item.getFood().getFoodId());
                        stm2.setInt(3, item.getQuantity());
                        stm2.setDouble(4, item.getPrice());
                        
                        int inserResult =  stm2.executeUpdate();
                        if (inserResult > 0) {
                            System.out.println("MakeOrdeR__Insert to Order_detail Sucesss");
                        }
                    }
                }
                
                String sql3 = "Update dbo.Food set foodQuantity = foodQuantity - ? where foodId = ? ";
                stm3 = con.prepareStatement(sql3);
                
                for (Item item : cart.getItems()) {
                    stm3.setInt(1, item.getQuantity());
                    stm3.setString(2, item.getFood().getFoodId());
                    int updateResult = stm3.executeUpdate();
                    if(updateResult > 0) {
                        System.out.println("MakeOrder__ Update Sucesss");
                    }
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
    }
}
