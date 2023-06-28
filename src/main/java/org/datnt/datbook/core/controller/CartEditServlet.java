/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.datnt.datbook.core.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import org.datnt.datbook.core.cart.Cart;
import org.datnt.datbook.core.food.FoodDAO;
import org.datnt.datbook.core.food.FoodDTO;
import org.datnt.datbook.core.item.Item;

/**
 *
 * @author datnt
 */
@WebServlet(name = "CartEditServlet", urlPatterns = {"/CartEditServlet"})
public class CartEditServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartEditServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartEditServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            FoodDAO dao = new FoodDAO();
            List<FoodDTO> listFood = dao.getAll();
            Cookie[] cookies = request.getCookies();
            String txt = "";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("Cart")) {
                        txt += cookie.getValue();
                    }
                }
            }
            Cart cart = new Cart(txt, listFood);

            try {
                String status = request.getParameter("status");
                String foodId = request.getParameter("id");

                Item item = cart.getItemById(foodId);
//                
//                int quantity_raw = Integer.parseInt(quantity);
                if(status.equals("remove")) {   
                    cart.removeItemFromCart(item);
                } else if (status.equals("add")) {
                    cart.addItemToCart(item);
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

            List<Item> items = cart.getItems();
            txt = "";
            if (items.size() > 0) {
                txt += items.get(0).getFood().getFoodId() + ":"
                        + items.get(0).getQuantity();
                for (int i = 1; i < items.size(); i++) {
                    txt += "/"+items.get(i).getFood().getFoodId() + ":"
                            + items.get(i).getQuantity();
                }
            }

            Cookie cookie = new Cookie("Cart", txt);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
            request.setAttribute("Cart", cart);
            HttpSession session = request.getSession();
            session.setAttribute("size", cart.getItems().size());
        } catch (SQLException ex) {
            log("CartEditServlet__SQLException__" + ex.getMessage());
        } finally {
            request.getRequestDispatcher("cartdetail.jsp").forward(request, response);
        }
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
