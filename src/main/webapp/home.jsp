<%-- 
    Document   : home.jsp
    Created on : Jun 2, 2023, 1:29:18 PM
    Author     : datnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <link rel="stylesheet" href="assets/resetcss.css">
        <link rel="stylesheet" href="assets/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&family=Roboto:wght@300&display=swap" rel="stylesheet">
        <title>Food Store</title>
    </head>
    <body>
        
        <a href="login.jsp">click here to login</a> </br>
        <a href="register.jsp">click here to register</a></br>
        <a href="ShopServlet">click here to Buy Food</a>

        <jsp:include page="_headerLayout.html"></jsp:include>

        <div class="content">
            <div class="container">
                <div class="banner banner-warpper">
                    <img src="https://cdn.shopify.com/s/files/1/1111/3280/files/HomepageBanner2F_2021_2500x.progressive.jpg?v=1635904976"
                         alt="">
                    <img src="https://cdn.shopify.com/s/files/1/0521/5784/1585/collections/the_pet_shop_banner_1378_x_288.jpg?v=1653636527"
                         alt="">
                    <img src="https://cdn.shopify.com/s/files/1/0521/5784/1585/files/coming_soon.jpg?v=1629961464"
                         alt="">
                </div>
                <div class="product-container">
                    <div class="row product-list">
                        <div class="col-12 product-list__title">Thức ăn cho chim</div>
                        <div class="row product-row g-0">
                            <div class="col-4 product-img-banner">
                                <img src="/images/product.png" alt="Product Imgage" srcset="">
                            </div>
                            <div class="row col-8">
                                <div class="product-warpper">
                                    <!-- <div class="routing-warpper"> -->
                                    <div class="product-item">
                                        <div class="product-content product-border">
                                            <div class="product-img-item"></div>
                                            <div class="product-desc">
                                                <div class="product-desc__title">Food Bird</div>
                                                <div class="product-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="product-content product-border">
                                            <div class="product-img-item"></div>
                                            <div class="product-desc">
                                                <div class="product-desc__title">Thức ăn cho chim</div>
                                                <div class="product-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="product-content product-border">
                                            <div class="product-img-item"></div>
                                            <div class="product-desc">
                                                <div class="product-desc__title">Thức ăn cho chim</div>
                                                <div class="product-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="product-content product-border">
                                            <div class="product-img-item"></div>
                                            <div class="product-desc">
                                                <div class="product-desc__title">Thức ăn cho chim</div>
                                                <div class="product-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-item">
                                        <div class="product-content product-border">
                                            <div class="product-img-item"></div>
                                            <div class="product-desc">
                                                <div class="product-desc__title">Thức ăn cho chim</div>
                                                <div class="product-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 watch-more__button">
                                    <button type="button" class="btn btn-warning btn-lg watch-more--button">Xem thêm</button>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row product-list">
                        <div class="col-12 product-list__title">Lộ trình cho chim</div>
                        <div class="row routing-row g-0">
                            <div class="col-4 routing-img-banner">
                                <img src="/images/routing.png" alt="routing Imgage" srcset="">
                            </div>
                            <div class="row col-8">
                                <div class="product-warpper">
                                    <!-- <div class="routing-warpper"> -->
                                    <div class="routing-item">
                                        <div class="routing-content product-border">
                                            <div class="routing-img-item"></div>
                                            <div class="routing-desc">
                                                <div class="routing-desc__title">Bữa ăn cho chim</div>
                                                <div class="routing-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="routing-item">
                                        <div class="routing-content product-border">
                                            <div class="routing-img-item"></div>
                                            <div class="routing-desc">
                                                <div class="routing-desc__title">Bữa ăn cho chim</div>
                                                <div class="routing-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="routing-item">
                                        <div class="routing-content product-border">
                                            <div class="routing-img-item"></div>
                                            <div class="routing-desc">
                                                <div class="routing-desc__title">Bữa ăn cho chim</div>
                                                <div class="routing-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="routing-item">
                                        <div class="routing-content product-border">
                                            <div class="routing-img-item"></div>
                                            <div class="routing-desc">
                                                <div class="routing-desc__title">Bữa ăn cho chim</div>
                                                <div class="routing-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="routing-item">
                                        <div class="routing-content product-border">
                                            <div class="routing-img-item"></div>
                                            <div class="routing-desc">
                                                <div class="routing-desc__title">Bữa ăn cho chim</div>
                                                <div class="routing-desc__price">100.000vnd</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 watch-more__button">
                                    <button type="button" class="btn btn-lg watch-more--button">Xem thêm</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Blog warper -->
                <div class="blog-container">
                    <div class="row blog-list">
                        <div class="col-12 product-list__title">Danh sách Blog</div>
                        <div class="row g-0">
                            <div class="blog-warpper">
                                <div class="blog-item">
                                    <div class="blog-content">
                                        <div class="blog-img">
                                            <img src="images/chim_canh_cut_hoang_de.jpg"
                                                 alt="">
                                        </div>
                                        <div class="blog-desc">
                                            Đài BBC ngày 11-11 cho biết chú chim cánh cụt Adélie kể trên được cư dân địa phương đặt tên là Pingu. Nó được tìm thấy ở bãi biển New Zealand, cách môi trường sống tự nhiên ở Nam Cực ít nhất 3.000 km.
                                        </div>
                                    </div>
                                </div>
                                <div class="blog-item">
                                    <div class="blog-content">
                                        <div class="blog-img">
                                            <img src="images/chimcanhcut.jpg"
                                                 alt="">
                                        </div>
                                        <div class="blog-desc">
                                            Đài BBC ngày 11-11 cho biết chú chim cánh cụt Adélie kể trên được cư dân địa phương đặt tên là Pingu. Nó được tìm thấy ở bãi biển New Zealand, cách môi trường sống tự nhiên ở Nam Cực ít nhất 3.000 km.
                                        </div>
                                    </div>
                                </div>
                                <div class="blog-item">
                                    <div class="blog-content">
                                        <div class="blog-img">
                                            <img src="images/chimcanhcut2.jpg"
                                                 alt="">
                                        </div>
                                        <div class="blog-desc">
                                            Đài BBC ngày 11-11 cho biết chú chim cánh cụt Adélie kể trên được cư dân địa phương đặt tên là Pingu. Nó được tìm thấy ở bãi biển New Zealand, cách môi trường sống tự nhiên ở Nam Cực ít nhất 3.000 km.
                                        </div>
                                    </div>
                                </div>
                                <div class="blog-item">
                                    <div class="blog-content">
                                        <div class="blog-img">
                                            <img src="images/chim_canh_cut_hoang_de.jpg"
                                                 alt="">
                                        </div>
                                        <div class="blog-desc">
                                            Đài BBC ngày 11-11 cho biết chú chim cánh cụt Adélie kể trên được cư dân địa phương đặt tên là Pingu. Nó được tìm thấy ở bãi biển New Zealand, cách môi trường sống tự nhiên ở Nam Cực ít nhất 3.000 km.
                                        </div>
                                    </div>
                                </div>
                                <div class="blog-item">
                                    <div class="blog-content">
                                        <div class="blog-img">
                                            <img src="images/chimcanhcut.jpg"
                                                 alt="">
                                        </div>
                                        <div class="blog-desc">
                                            Đài BBC ngày 11-11 cho biết chú chim cánh cụt Adélie kể trên được cư dân địa phương đặt tên là Pingu. Nó được tìm thấy ở bãi biển New Zealand, cách môi trường sống tự nhiên ở Nam Cực ít nhất 3.000 km.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="_footerLayout.html"></jsp:include>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"
                integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <!-- slick carousel -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
        <script type="text/javascript" src="assets/main.js"></script>
    </body>
</html>
