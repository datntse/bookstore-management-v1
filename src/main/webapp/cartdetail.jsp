<%-- 
    Document   : cartdetail
    Created on : Jun 5, 2023, 4:45:10 PM
    Author     : datnt
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table {
            border-collapse: collapse;
        }
        .text-align-right {
            text-align: right;
        }
        a {
            text-decoration: none;
            color: chocolate;
            font-size: 22px;
            font-weight: bold;
        }
    </style>
    <body>
        <h1>Shoping cart</h1>
        <table border="1px" width="40%">
            <tr>
                <th>No</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total money</th>
                <th>Action</th>
            </tr>
            <c:forEach var="item" items="${requestScope.Cart.items}" varStatus="counter">
                <c:set var="quantity" value="${item.quantity}"/>
                <c:set var="price" value="${item.price}"/>
                <tr>
                    <td>${counter.count}</td>
                    <td>${item.food.foodName}</td>
                    <td>
                        <button><a href="DispatchServlet?btnAction=EditCart&quantity=remove1&id=${item.food.foodId}">-</a></button>    
                        ${quantity}
                        <button><a href="DispatchServlet?btnAction=EditCart&quantity=add1&id=${item.food.foodId}">+</a></button> 
                    </td>
                    <td class="text-align-right">${price}</td>
                    <td class="text-align-right">${quantity*price}</td>
                    <td style="text-align: center">
                        <form action="DispatchServlet?btnAction=RefundCart" method="POST">
                            <input type="hidden" name="id" value="${item.food.foodId}" />
                            <input type="submit" value="ReturnItem">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
            <c:set var="cartObj" value="${requestScope.Cart}"/>
            
            <h3>Total Money:$ ${cartObj.totalMoney} </h3> 
        <form action="DispatcServlet">
            <input type="submit" name="btnAction" value="Checkout">
        </form>
        
        <a href="ShopServlet">Click me to continue to shoping</a>
    </body>
</html>
