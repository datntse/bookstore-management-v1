<%-- 
    Document   : register
    Created on : Jun 3, 2023, 2:59:49 AM
    Author     : datnt
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="vn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/register.css">
    <link rel="stylesheet" href="assets/reset.css">
    <title>Đăng ký tài khoản</title>
</head>

<body>
    <div id="wrapper">
        <div id="form-register">

            <div class="register-account">
                <form action="DispatcheServlet" method="post">
                    <c:set var="errors" value="${requestScope.ERROR_REGISTER}"/>
                    <h2>Đăng ký tài khoản</h2>
                       
                    <div class="form-group">
                         <c:if test="${not empty errors.fullNameLengthErrorr}">
                             <font color="red">
                                 ${errors.fullNameLengthErrorr}
                             </font>
                        </c:if>
                        <label for="lastname"></label>
                        <input type="text" name="txtFullName" value="" id="" class="input input--lastname"
                            placeholder="Tên đầy đủ" required>
                    </div>
                    <div class="form-group">
                        <c:if test="${not empty errors.userNameLengthError}">
                             <font color="red">
                                 ${errors.userNameLengthError}
                             </font>
                        </c:if>
                        <label for="email"></label>
                        <input type="text" name="txtUserName" value="" id="" class="input input--email" placeholder="E-mail" required>
                    </div>
                    <div class="form-group">
                        <c:if test="${not empty errors.passwordLengthError}">
                             <font color="red">
                                 ${errors.passwordLengthError}
                             </font>
                        </c:if>
                        <label for="password"></label>
                        <input type="password" name="txtPassword" value="" id="password" class="input input--password"
                            placeholder="Mật khẩu" required>
                    </div>
                    <div class="form-group">
                        <c:if test="${not empty errors.confirmNotMatched}">
                             <font color="red">
                                 ${errors.confirmNotMatched}
                             </font>
                        </c:if>
                        <label for="confirmPassword"></label>
                        <input type="password" name="txtPasswordConfirm" value="" id="confirm_password" class="input input--password"
                            placeholder="Nhập lại mật khẩu" required>
                    </div>
                    <div class="form-group">
                        <button type="submit" value="CreateNewAccount" name="btnAction" class="btn btn-login"><b>Đăng ký</b></button>
                    </div>
                </form>
            </div>

            <div class="login-social">
                <div class="recommend">
                    <div class="line">
                        <span class="text">Hoặc đăng nhập qua</span>
                    </div>
                </div>
                <div class="icon">
                    <a href="http://" class="login-icon"><img width="150px" height="40px" src="images/fb.png"
                            alt=""></a>
                    <a href="http://" class="login-icon"><img width="150px" height="40px" src="images/gg.png"
                            alt=""></a>
                </div>
            </div>

            <div class="others">
                <div class="others-button">
                    <a href="login.jsp" class="btn btn-name"><b>Đăng nhập</b></a>
                    <a href="ShopServlet" class="btn btn-name"><b>Quay lại trang chủ</b></a>
                </div>
            </div>

        </div>
    </div>

    <script src="js/site.js"></script>
</body>

</html>
</html>
