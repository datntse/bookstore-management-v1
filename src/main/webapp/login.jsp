<%-- 
    Document   : login.jsp
    Created on : Jun 2, 2023, 4:49:53 PM
    Author     : datnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Login Page </h1>
        <form action="DispatchServlet" method="POST">
            UserName: <input type="text" name="txtUsername" value="" size="60" /> </br>
                Password: <input type="password" name="txtPassword" value="" size="60" />  </br>
            <input type="submit" value="Login" name="btnAction" />
            <input type="reset" value="resert" />
            <a href="register.jsp">Click here to register</a>
        </form>
    </body>
</html>
