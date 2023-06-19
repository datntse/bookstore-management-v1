<%-- 
    Document   : login.jsp
    Created on : Jun 2, 2023, 4:49:53 PM
    Author     : datnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <body>
    
       
        
        <!DOCTYPE html>
<html lang="vn">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/reset.css">
    <link rel="stylesheet" href="assets/login.css">
    <title>Đăng nhập tài khoản</title>
</head>

<body>
    <div id="wrapper">
        <div id="form-login">
            <div class="login-account">
                <form action="DispatchServlet" method="POST">
                    <h2>Đăng nhập</h2>
                    <div class="form-group">
                        <label for="username"></label>
                        <input type="text" name="txtUsername" value="" class="input input--username" placeholder="Tên tài khoản" required>
                    </div>

                    <div class="form-group">
                        <label for="password"></label>
                        <input type="password" name="txtPassword" value="" class="input input--password" placeholder="Mật khẩu" required>
                    </div>

                    <div class="form-group">
                        <div class="action">
                            <input type="submit" value="Login" name="btnAction" class="submit btn-login">
                            <a href="http://" class="submit btn-forgot"><b>Quên mật khẩu</b></a>
                        </div>
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
                    <a href="http://" class="login-icon"><img width="150px" height="40px" src="images/fb.png" alt=""></a>
                    <a href="http://" class="login-icon"><img width="150px" height="40px" src="images/gg.png" alt=""></a>
                </div>
            </div>

            <div class="others">
                <div class="others-text">
                    <p>
                        Tạo tài khoản để quản lý đơn hàng, và các thông tin thanh toán, gửi hàng một cách đơn giản hơn.
                    </p>
                </div>
                <div class="others-button">
                    <a href="register.jsp" class="btn btn-name">Tạo tài khoản mới</a>               
                    <a href="homepage.jsp" class="btn btn-name">Trở về Trang Chủ</a>             
                </div>               
            </div>

        </div>
    </div>
</body>

</html>
    </body>
</html>
