<%-- 
    Document   : foodlist
    Created on : Jun 28, 2023, 4:13:38 PM
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
        <title>Food Store</title>
    </head>
    <body>
        <jsp:include page="_headerLayout.jsp"></jsp:include>

            <div class="content">
                <div class="container">
                    <div class="content__navigation">
                        <div>
                            <a href="index.html">Trang chủ</a>/
                            <a href="routing.html">Sản phẩm</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3 content__sidebar">
                            <div class="container-sidebar__titile">
                                Sản phẩm cho thú cưng
                            </div>
                            <div class="container-sidebar__list">
                                <div class="col-12 sidebar__list-category--title">Category</div>
                                <ul class="col-12 container-sidebar__list--category">
                                    <li class="sidebar__list--category-item">
                                        <a href="#"
                                           class="sidebar__list--category-link">Thức ăn hạt</a>
                                    </li>
                                    <li class="sidebar__list--category-item">
                                        <a href="#"
                                           class="sidebar__list--category-link">Thức ăn tự nhiên</a>
                                    </li>
                                    <li class="sidebar__list--category-item">
                                        <a href="#"
                                           class="sidebar__list--category-link">Thức ăn khô</a>
                                    </li>
                                    <li class="sidebar__list--category-item">
                                        <a href="#"
                                           class="sidebar__list--category-link">Thức ăn mềm</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="container-sidebar__list">
                                <div class="col-12 sidebar__list-category--title">Lộ trình</div>
                                <ul class="col-12 container-sidebar__list--category">
                                    <li class="sidebar__list--category-item">
                                        <a href="#"
                                           class="sidebar__list--category-link">Cải thiện cân nặng</a>
                                    </li>
                                    <li class="sidebar__list--category-item">
                                        <a href="#"
                                           class="sidebar__list--category-link">Cải thiện sức khỏe</a>
                                    </li>
                                    <li class="sidebar__list--category-item">
                                        <a href="#"
                                           class="sidebar__list--category-link">Cải thiện màu lông</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="container-sidebar__list">
                                <div class="col-12 sidebar__list-category--title">Blog</div>
                                <ul class="col-12 container-sidebar__list--category">
                                    <li class="sidebar__list--category-item sidebar__blog-item">
                                        <a href="#" class="sidebar__list--category-link">
                                            <div class="blog-sidebar__img">
                                                <img src="images/product.png" alt="" srcset="">
                                            </div>
                                            <div class="blog-sidebar__text">
                                                Tràm chim nơi xuất hiện nhiều loại chim quý hiếm, có nhiều loài đang nằm trong sách Đỏ Việt Nam.
                                            </div>

                                        </a>
                                    </li>
                                    <li class="sidebar__list--category-item sidebar__blog-item">
                                        <a href="#" class="sidebar__list--category-link">
                                            <div class="blog-sidebar__img">
                                                <img src="images/routing.png" alt="" srcset="">
                                            </div>
                                            <div class="blog-sidebar__text">
                                                Tràm chim nơi xuất hiện nhiều loại chim quý hiếm, có nhiều loài đang nằm trong sách Đỏ Việt Nam.
                                            </div>

                                        </a>
                                    </li>
                                    <li class="sidebar__list--category-item sidebar__blog-item">
                                        <a href="#" class="sidebar__list--category-link">
                                            <div class="blog-sidebar__img">
                                                <img src="images/product.png" alt="" srcset="">
                                            </div>
                                            <div class="blog-sidebar__text">
                                                Tràm chim nơi xuất hiện nhiều loại chim quý hiếm, có nhiều loài đang nằm trong sách Đỏ Việt Nam.
                                            </div>

                                        </a>
                                    </li>
                                    <li class="sidebar__list--category-item sidebar__blog-item">
                                        <a href="#" class="sidebar__list--category-link">
                                            <div class="blog-sidebar__img">
                                                <img src="images/routing.png" alt="" srcset="">
                                            </div>
                                            <div class="blog-sidebar__text">
                                                Tràm chim nơi xuất hiện nhiều loại chim quý hiếm, có nhiều loài đang nằm trong sách Đỏ Việt Nam.
                                            </div>

                                        </a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        
                        <div class="col-9 content__routing-list content_product-list">
                            <div class="content__filter">
                                <ul class="content__fitler-list">
                                    <span>Sắp xếp:</span>
                                    <li class="content__filter-item">
                                        <input type="checkbox" name="sortAZ" id="sortAZ">
                                        <label for="sortAZ">A-Z</label>

                                    </li>
                                    <li class="content__filter-item">
                                        <input type="checkbox" name="sortZA" id="sortZA">
                                        <label for="sortZA">Z-A</label>
                                    </li>
                                    <li class="content__filter-item">
                                        <input type="checkbox" name="sortPriceIncrease" id="sortPriceIncrease">
                                        <label for="sortPriceIncrease">Giá tăng dần</label>
                                    </li>
                                    <li class="content__filter-item">
                                        <input type="checkbox" name="sortPriceDecrease" id="sortPriceDecrease">
                                        <label for="sortPriceDecrease">Giá giảm dần</label>
                                    </li>
                                    <li class="content__filter-item">
                                        <input type="checkbox" name="sortOld" id="sortOld">
                                        <label for="sortOld">Sản phẩm cũ</label>
                                    </li>
                                    <li class="content__filter-item">
                                        <input type="checkbox" name="sortNew" id="sortNew">
                                        <label for="sortNew">Sản phẩm mới</label>
                                    </li>
                                </ul>
                            </div>
                            <div class="content_product-list">
                                <div class="row g-0 product-list">
                                    <c:forEach var="item" items="${sessionScope.dataList}">
                                    <a class="col-3 product-item" asp-action="Details" asp-controller="TblProducts" asp-route-id="@item.ProductId" style="text-decoration: none">
                                        <div class="product-content product-border">
                                            <div class="product-img-item" style="background-image: url('${item.image}')"></div>
                                            <div class="product-desc">
                                                <div class="product-desc__title">${item.foodName}</div>
                                                <div class="product-desc__price">${item.foodPrice}00vnd</div>
                                                <button data-id="${item.foodId}" class="ajax-add-to-cart-btn buy-now btn btn-warning">Add to cart</button>
                                            </div>
                                        </div>
                                    </a>
                                </c:forEach>
                            </div>

                        </div>
                    </div>

                </div>

            </div>
        </div>
        <jsp:include page="_footerLayout.html"></jsp:include>
    </body>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script>
		$(document).ready(function () {
			$('.ajax-add-to-cart-btn').click(function (e) {
				var _id = $(this).data("id");
				console.log("Click o button");
				e.stopPropagation();
				$.ajax({
					url: "DispatchServlet?btnAction=BuyFood",
					data: {
						id: _id,
						productQuantity: 1
					},
                                        type: "GET",
					success: function (data) {
						Swal.fire({
							position: 'center',
							icon: 'success',
							title: 'Add product to cart success',
							showConfirmButton: false,
							timer: 1500
						});
//						$(".cart-quantity").html(data);
					},
					error: function () {

					}
				});
			});
		});
    </script>
</html>
