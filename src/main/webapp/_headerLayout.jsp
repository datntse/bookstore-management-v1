<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
        <!-- Header -->
        <div class="header">
            <div class="container">
                <div class="row header-search">
                    <div class="col-2 header-logo">
                        <img class="header-logo" src="https://bizweb.dktcdn.net/100/468/076/themes/882698/assets/logo.png?1677556977585" alt="Logo">
                    </div>
                    <div class="col-6 header-search__form">
                        <div class="header-search__form--input">
                            <input class="header-search__form--input-field" type="text" placeholder="Gõ từ khóa bạn muốn tìm kiếm">
                        </div>
                        <div class="header-search_form--button">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="row header-option">
                            <div class="col header-option-notify ">
                                <img src="images/bell.png" alt="">
                            </div>
                                <div class="col header-option-cart">
                            <a href="DispatchServlet?btnAction=viewCart">
                                    <img src="images/cart.png" alt="" srcset="">
                                    <c:set var="size" value="${sessionScope.size}"/>
                                    <c:if test="${not empty size}">
                                    <div class="cart-quantity">${size}</div>
                                    </c:if>
                            </a>
                                </div>
                            <div class="col header-option-profile">
                                <a href="login.jsp">
                                    <img src="images/user-icon.png" alt="">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Navbar -->
        <div class="header-navbar">
            <div class="container header-navbar__list">
                <ul class="header-navbar__page-list">
                    <li class="header-navbar__page-list-item"><a href="ShopServlet"
                                                                 class="header-navbar__page-list-item-link">Trang chủ</a></li>
                    <li class="header-navbar__page-list-item"><a href="#"
                                                                 class="header-navbar__page-list-item-link">Về cửa hàng</a></li>
                    <li class="header-navbar__page-list-item"><a href="FoodListServlet"
                                                                 class="header-navbar__page-list-item-link">Sản phẩm</a></li>
                    <li class="header-navbar__page-list-item"><a href="routing.html"
                                                                 class="header-navbar__page-list-item-link">Lộ trình ăn</a></li>
                    <li class="header-navbar__page-list-item"><a href="blog.html"
                                                                 class="header-navbar__page-list-item-link">Blog</a></li>
                </ul>
                <div class="header-navbar__location-shop">
                    <div class="location-shop__title">Địa chỉ cửa hàng</div>
                    <div class="location-shop__icon">
                        <img src="images/location-icon.png" alt="" srcset="">
                    </div>
                </div>
            </div>
        </div>
</html>
