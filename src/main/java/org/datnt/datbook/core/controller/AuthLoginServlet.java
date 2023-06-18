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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import org.datnt.datbook.core.account.AccountDAO;
import org.datnt.datbook.core.account.AccountDTO;


/**
 *
 * @author datnt
 */
@WebServlet(name = "AuthLoginServlet", urlPatterns = {"/AuthLoginServlet"})
public class AuthLoginServlet extends HttpServlet {
    private final String INVALID_PAGE = "invalid.jsp";
    private final String SERACH_ACTION = "search.jsp";
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
            String url = INVALID_PAGE;
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            
            try {
                AccountDAO dao = new AccountDAO();
                AccountDTO validUser = dao.getAccountByUserAndPassword(username, password);
                
                if(validUser != null) {
                    url = SERACH_ACTION;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", validUser);
                }
            } catch (SQLException ex) {
                log("Authentication _ SQL _ " + ex.getMessage());
            } catch (NamingException ex) {
                log("Authentication _ Naming _ " + ex.getMessage());
            } finally {
                response.sendRedirect(url);
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
