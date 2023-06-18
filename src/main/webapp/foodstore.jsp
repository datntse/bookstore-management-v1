<%-- 
    Document   : foodstore.jsp
    Created on : Jun 4, 2023, 8:23:21 PM
    Author     : datnt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                border-collapse: collapse;
            }
            #bag {
                text-align: right;
                margin-right: 30px;
                margin-top: 30px;
            }
            .text-align-right {
                text-align: right;
            }

        </style>
    </head>
    <body>
        <p id="bag">
            <img src="images/cart.jpg" width="50px" height="50px"/>
            <a href="DispatchServlet?btnAction=viewCart">MyBag (${requestScope.size} items)</a>
        </p>
        <h1>List of food</h1>
        <form name="buyFoodForm" method="POST">
            Enter number of items to buy:
            <input style="text-align: center" type="text" name="txtItemNumber" value="1" />
            <hr/>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Type</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.dataList}" var="foodItem">
                        <c:set var="id" value="${foodItem.foodId}"  />
                        <tr>
                            <td>
                                ${id}
                                <input type="hidden" name="txtFoodId" value="${id}" />
                            </td>     
                            <td>${foodItem.foodName}</td>   
                            <td class="text-align-right">${foodItem.foodQuantity}</td>   
                            <td class="text-align-right">
                                <fmt:formatNumber pattern="##.#" value="${foodItem.foodPrice}"/>
                            </td>   
                            <td>${foodItem.foodType}</td>     
                            <td>
                                <input type="button" onclick="buyItem('${id}')" name="btnAction" value="BuyFood" />
                            </td>     
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </form>
    </body>

    <script type="text/javascript">
        function buyItem(id) {
            var quantity = buyFoodForm.txtItemNumber.value;
            document.buyFoodForm.action = "DispatchServlet?btnAction=BuyFood&id=" + id +"&quantity=" + quantity;
            document.buyFoodForm.submit();
        }
    </script>
</html>
