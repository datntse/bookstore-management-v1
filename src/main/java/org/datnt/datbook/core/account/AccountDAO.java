/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.datnt.datbook.core.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.datnt.datbook.utils.DBHelper;

/**
 *
 * @author datnt
 */
public class AccountDAO {
    
    
    public int getListAccountLength() {
        Connection con = null;  
        PreparedStatement stm = null;
        ResultSet rs = null;
        int length = 0;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                String sql = "SELECT COUNT(*) FROM dbo.Account";
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
    public AccountDTO getAccountByUserAndPassword(String username, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO dto = null;
    
        
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT userId, fullName, isAdmin FROM dbo.Account WHERE username = ? "
                        + "AND password =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullName");
                    String userId = rs.getString("userId");
                    Boolean isAdmin = rs.getBoolean("isAdmin");
                    dto = new AccountDTO(userId, username, password, fullname, isAdmin, false);
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
        return dto;
    }

    // Add account 
    public boolean addAccount(String username, String password, String fullname)
            throws SQLException, NamingException {
        Connection con = null;  
        PreparedStatement stm = null;
        int id = getListAccountLength();
        String userId = "user0" + id;
        System.out.println(userId);
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "INSERT INTO dbo.Account(userId, username, password, fullName, isAdmin, isDisable  ) "
                        + "VALUES(?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, userId);
                stm.setString(2, username);
                stm.setString(3, password);
                stm.setString(4, fullname);
                stm.setBoolean(5, false);
                stm.setBoolean(6, false);

                int result = stm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    // Search account by full name
    public List<AccountDTO> searchAccountByFullName(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        List<AccountDTO> listAccount = new ArrayList<AccountDTO>();

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT userId, username, password, fullName, isAdmin, isDisable from dbo.Account WHERE fullName LIKE ?";
//                        + " AND isDisable = 0";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();

                while(rs. next()) {
                    String userId = rs.getString("userId");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullname = rs.getString("fullName");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    boolean isDisable = rs.getBoolean("isDisable");
                    
                    AccountDTO dto = new AccountDTO(userId, username, password, fullname, isAdmin, isDisable);
                    listAccount.add(dto);
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
        return listAccount;
    }

    //delete Account 
        public boolean deleteAccount(String pk)
            throws SQLException, NamingException /*ClassNotFoundException*/ {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        // tu dong 29 - 43: connect DB va Query
        //1. Connect DB
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                //check connection truoc khi su dung SQL code
                //2. Write SQL command
                String sql = "UPDATE dbo.Account SET isDisable = 1 "
                        + "WHERE username = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                // Nếu có params thì phải thiết lập tham số vào trong stm.
                stm.setString(1, pk);
                //4. Excecute Statement Object to get result.
                int effectRows = stm.executeUpdate();
                //5. Process result.    
                if (effectRows > 0) {
                    result = true;
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
        return result;

    }
    // deleteAccount
    public boolean updateAccount(String username, String password, String fullname, boolean isDisable)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "UPDATE dbo.Account SET password = ?, fullName = ?, isDisable = ? "
                        + "WHERE username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, fullname);
                stm.setBoolean(3, isDisable);
                stm.setString(4, username);

                int result = stm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
