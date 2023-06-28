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
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css ">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
        <link rel="stylesheet" href="assets/reset.css">
        <link rel="stylesheet" href="assets/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&family=Roboto:wght@300&display=swap" rel="stylesheet">
        <title>Cart detail</title>
    </head>
    <jsp:include page="_headerLayout.jsp"></jsp:include>
        <body>
        <c:set var="cart" value="${requestScope.Cart}"/>
        <c:if test="${sessionScope.size > 0}">
            <div class="container mt-3 cart-wrapper">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12">
                        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                            <div class="card-body p-0">
                                <div class="row g-0">
                                    <div class="col-lg-8">
                                        <div class="p-5">
                                            <div class="d-flex justify-content-between align-items-center mb-5">
                                                <h1 class="fw-bold mb-0 text-black">Giỏ Hàng</h1>
                                                <h6 class="mb-0 text-muted">${sessionScope.size} items</h6>
                                            </div>
                                            <hr class="my-4">
                                            <c:forEach var="item" items="${cart.items}" varStatus="counter">
                                                <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                    <div class="col-md-2 col-lg-2 col-xl-2">
                                                        <img src="${item.food.image}" style="width: 50px; height: 50px" />
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-3">
                                                        <h6 class="text-muted">${item.food.foodName}</h6>
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                        <button data-id="${item.food.foodId}" class="btn btn-link px-2 decrease-prodQuantity-btn"
                                                                onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                            <i class="fas fa-minus"></i>
                                                        </button>

                                                        <input data-id="${item.food.foodId}" input type="number" value="${item.quantity}" name="cartItemQuantity"
                                                               class="form-control form-control-sm input-food-quantity" />

                                                        <button data-id="${item.food.foodId}" class="btn btn-link px-2 increase-prodQuantity-btn"
                                                                onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                            <i class="fas fa-plus"></i>
                                                        </button>
                                                    </div>
                                                    <div class="col-md-3 col-lg-1 col-xl-1 offset-lg-1">
                                                        <h6 class="mb-0">${item.food.foodPrice}</h6>
                                                    </div>
                                                    <div data-id="${item.food.foodId}" class="ajax-remove-item col-md-1 col-lg-1 col-xl-1 text-end">
                                                        <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                    </div>
                                                </div>
                                            </c:forEach>

                                            <hr class="my-4">

                                            <div class="pt-5">
                                                <h6 class="mb-0">
                                                    <a href="ShopServlet" class="text-body">
                                                        <i class="fas fa-long-arrow-alt-left me-2"></i>Back to shop
                                                    </a>
                                                </h6>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 bg-grey">
                                        <div class="p-5">
                                            <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                            <div class="d-flex justify-content-between mb-5">
                                                <h5 class="text-uppercase">Total price</h5>
                                                <h5>${cart.totalMoney}</h5>
                                            </div>
                                            <a href="DispatchServlet?btnAction=Checkout">
                                                <button type="button" class="btn btn-dark btn-block btn-lg"
                                                        data-mdb-ripple-color="dark">
                                                    Thanh Toán
                                                </button>
                                            </a>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.size == 0}">
            <div style="background-image: url('images/empty_cart.svg'); background-size: contain; width: 800px; height: 50vh; background-repeat: no-repeat; background-position:center; margin: 0 auto;">
                <div class="pt-5">
                    <h6 class="mb-0">
                        <a href="home.jsp" class="text-body">
                            <i class="fas fa-long-arrow-alt-left me-2"></i>Nhấn vào đây để trở lại mua hàng
                        </a>
                    </h6>
                </div>
            </div>
        </c:if>
        <jsp:include page="_footerLayout.html"></jsp:include>
    </body>

    <script>
        $(document).ready(function () {
            $('.ajax-remove-item').click(function (e) {
                var _id = $(this).data("id");
                $.ajax({
                    url: "DispatchServlet?btnAction=RefundCart",
                    data: {
                        id: _id,
                    },
                    type: "GET",
                    success: function (data) {
                        $("body").html(data)
                    },
                })
            });

            $('.decrease-prodQuantity-btn').click(function (e) {
                var _id = $(this).data("id");
                $.ajax({
                    url: "DispatchServlet?btnAction=EditCart",
                    data: {
                        status: "remove",
                        id: _id,
                    },
                    type: "GET",
                    success: function (data) {
                        $("body").html(data)
                    },
                });
            });
            $('.increase-prodQuantity-btn').click(function (e) {
                var _id = $(this).data("id");
                $.ajax({
                    url: "DispatchServlet?btnAction=EditCart",
                    data: {
                        status: "add",
                        id: _id,
                    },
                    type: "GET",
                    success: function (data) {
                        $("body").html(data)
                    },
                });
            });

        });
    </script>
</html>
