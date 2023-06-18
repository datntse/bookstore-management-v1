/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.datnt.datbook.core.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import org.datnt.datbook.core.cart.Cart;
import org.datnt.datbook.core.food.FoodDAO;
import org.datnt.datbook.core.food.FoodDTO;

/**
 *
 * @author datnt
 */
@WebServlet(name = "CartReFundFoodServlet", urlPatterns = {"/CartReFundFoodServlet"})
public class CartReFundFoodServlet extends HttpServlet {

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
        try {
            FoodDAO dao = new FoodDAO();
            List<FoodDTO> listFood = dao.getAll();
            Cookie[] cookies = request.getCookies();
            String txt = "";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("Cart")) {
                        txt += cookie.getValue();
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
                String id = request.getParameter("id");
                String[] ids = txt.split("/");
                String out = "";

                for (int i = 0; i < ids.length; i++) {
                    String[] s = ids[i].split(":");
                    if (!s[0].equals(id)) {
                        if (out.isEmpty()) {
                            out = ids[i];
                        } else {
                            out += "/" + ids[i];
                        }
                    }
                }
                if (!out.isEmpty()) {
                    Cookie cookie = new Cookie("Cart", out);
                    cookie.setMaxAge(60 * 60 * 24 * 7);
                    response.addCookie(cookie);
                }

                Cart cart = new Cart(out, listFood);
                request.setAttribute("Cart", cart);
                request.getRequestDispatcher("cartdetail.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            log("CartRefundFoodServlet __ SQL Exception " + ex.getMessage());
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
