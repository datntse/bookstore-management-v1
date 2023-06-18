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

/**
 *
 * @author datnt
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {

    private static final String AUTH_LOGIN_SERVLET = "AuthLoginServlet";
    private static final String LOGOUT_SERVLET = "AuthLogoutServlet";
    private static final String SEARCH_ACCOUNT_SERVLET = "AccountSearchServlet";
    private static final String DELETE_ACCOUNT_SERVLET = "AccountDeleteServlet";
    private static final String UPDATE_ACCOUNT_SERVLET = "AccountUpdateServlet";
    private static final String CREATE_ACCOUNT_SERVLET = "AccountCreateServlet";
    
    private static final String BUY_FOOD_SERVLET = "FoodBuyServlet";
    private static final String CART_DETAIL_SERVLET = "CartDetailServlet";
    private static final String CART_EDIT_SERVLET = "CartEditServlet";
    private static final String CART_REFUND_FOOD_SERVLET = "CartReFundFoodServlet";
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
        String url = "invalid.jsp";
        String button = request.getParameter("btnAction");
        if (button == null) {
            url = "home.jsp";
        } else if (button.equals("Login")) {
            url = AUTH_LOGIN_SERVLET;
        } else if (button.equals("Logout")) {
            url = LOGOUT_SERVLET;
        } else if (button.equals("SearchAccount")) {
            url = SEARCH_ACCOUNT_SERVLET;
        } else if (button.equals("DeleteAccount")) {
            url = DELETE_ACCOUNT_SERVLET;
        } else if (button.equals("UpdateAccount")) {
            url = UPDATE_ACCOUNT_SERVLET;
        } else if (button.equals("CreateNewAccount")) {
            url = CREATE_ACCOUNT_SERVLET;
        } else if (button.equals("BuyFood")) {
            url = BUY_FOOD_SERVLET;
        }  else if (button.equals("viewCart")) {
            url = CART_DETAIL_SERVLET;
        }  else if (button.equals("EditCart")) {
            url = CART_EDIT_SERVLET;
        } else if (button.equals("RefundCart")) {
            url = CART_REFUND_FOOD_SERVLET;
        }
        request.getRequestDispatcher(url).forward(request, response);

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
