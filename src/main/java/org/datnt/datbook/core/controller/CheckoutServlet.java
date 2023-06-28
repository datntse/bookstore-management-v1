/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.datnt.datbook.core.controller;

import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import org.datnt.datbook.core.account.AccountDTO;
import org.datnt.datbook.core.cart.Cart;
import org.datnt.datbook.core.food.FoodDAO;
import org.datnt.datbook.core.food.FoodDTO;
import org.datnt.datbook.core.order.OrderDAO;

/**
 *
 * @author datnt
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

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
            for (Cookie c : cookies) {
                if (c.getName().equals("Cart")) {
                    txt += c.getValue();
                }
            }
        }

        Cart cart = new Cart(txt, listFood);
        HttpSession session = request.getSession();
        AccountDTO account = (AccountDTO) session.getAttribute("USER");

        if (account == null) {
            response.sendRedirect("login.jsp");
        } else {
            OrderDAO OrderDao = new OrderDAO();
            OrderDao.makeOrder(account, cart);
            Cookie cookie = new Cookie("Cart", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            session.setAttribute("size", 0);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
            
        } catch (SQLException e) {
            log("CheckoutServlet__SQLException__"+ e.getMessage());
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
