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
import org.datnt.datbook.core.account.AccountUpdateError;

/**
 *
 * @author datnt
 */
@WebServlet(name = "AccountUpdateServlet", urlPatterns = {"/AccountUpdateServlet"})
public class AccountUpdateServlet extends HttpServlet {

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
        String username = request.getParameter("txtHiddenUsername");
        String password = request.getParameter("txtHiddenPassword");
        String fullName = request.getParameter("txtHiddenFullname");
        String searchValue = request.getParameter("lastSearchValue");
        String checkDisable = request.getParameter("isDisable");
        boolean isDisable = false;

        String urlRewriting = "DispatchServlet"
                            + "?btnAction=SearchAccount"
                            + "&txtSearchValue=" + searchValue;
        AccountUpdateError error = new AccountUpdateError();
        boolean isError = false;
        try {
            if (password.trim().length() <= 0) {
                error.setPasswordIsEmptyError("Password cannot be blank");
                isError = true;
            }
            if (fullName.trim().length() <= 0) {
                error.setFullnameIsEmptyError("Full name cannot be blank");
                isError = true;
            }

            if (isError) {
                request.setAttribute("ERROR", error);
                request.setAttribute("ERROR_PK", username);
            } else {
                if (checkDisable != null) {
                    isDisable = true;
                }
                AccountDAO dao = new AccountDAO();
                boolean result = dao.updateAccount(username, password, fullName, isDisable);
                if (result) {
                    urlRewriting = "DispatchServlet"
                            + "?btnAction=SearchAccount"
                            + "&txtSearchValue=" + searchValue;
                }
            }

        } catch (SQLException ex) {
            log("AccountSearchSevlet _ SQL _ " + ex.getMessage());
        } catch (NamingException ex) {
            log("AccountSearchSevlet _ NamingException " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(urlRewriting).forward(request, response);
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
