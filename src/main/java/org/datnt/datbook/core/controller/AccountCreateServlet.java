/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.datnt.datbook.core.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import org.datnt.datbook.core.account.AccountDAO;
import org.datnt.datbook.core.account.AccountRegisterError;

/**
 *
 * @author datnt
 */
@WebServlet(name = "AccountCreateServlet", urlPatterns = {"/AccountCreateServlet"})
public class AccountCreateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String userName = request.getParameter("txtUserName");
            String password = request.getParameter("txtPassword");
            String passwordConfirm = request.getParameter("txtPasswordConfirm");
            String fullName = request.getParameter("txtFullName");
            
            String url = "register.jsp";    
            boolean isError = false;
            AccountRegisterError errors = new AccountRegisterError();

            try {
                if ((userName.trim().length()  < 6) || (userName.trim().length() > 20)) {
                    errors.setUserNameLengthError("Username is required input form 6 to 20 characters");
                    isError = true;
                }

                if (password.trim().length() < 6 || password.trim().length() > 30) {
                    errors.setPasswordLengthError("Password is required input form 6 to 30 characters");
                    isError = true;

                } else if (!(passwordConfirm.trim().equals(password.trim()))) {
                    errors.setConfirmNotMatched("Confirm must matched password");
                    isError = true;
                }

                if (fullName.trim().length() < 2|| fullName.trim().length() > 50) {
                    errors.setFullNameLengthError("Full name is required input form 2 to 50 characters");
                    isError = true;
                }
                
                if (isError) {
                    request.setAttribute("ERROR_REGISTER", errors);
                } else {
                    AccountDAO dao = new AccountDAO();
                    boolean result = dao.addAccount(userName, password, fullName);
                    if (result) {
                        url = "login.jsp";
                    }
                }

            } catch (SQLException ex) {
                log("AccountSearchSevlet _ SQL _ " + ex.getMessage());
            } catch (NamingException ex) {
                log("AccountSearchSevlet _ NamingException " + ex.getMessage());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
