<%-- 
    Document   : search
    Created on : Jun 2, 2023, 4:53:03 PM
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
    <body>
        <c:set var="ADMIN" value = "${sessionScope.ADMIN}"/>

        <c:if test="${empty ADMIN}">
            <jsp:forward  page="home.jsp"></jsp:forward>     
        </c:if>

        <h1> Welcome ${USER.fullName}</h1>
        <form action="DispatchServlet">
            <input type="submit" value="Logout" name="btnAction" />
        </form>

        <form action="DispatchServlet" method="GET">
            Search Value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" size="30" />
            <input type="submit" value="SearchAccount" name="btnAction" />
        </form>

        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_RESULT}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>userid</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Fullname</th>
                            <th>Disable</th>
                            <th>Action</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="DispatchServlet" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>
                                    ${dto.username}
                                    <input type="hidden" name="txtHiddenUsername" value="${dto.username}" />
                                </td>
                                <td>
                                    <input type="text" name="txtHiddenPassword" value="${dto.password}" />
                                    <c:if test="${not empty requestScope.ERROR.passwordIsEmptyError and requestScope.ERROR_PK == dto.username}" >
                                        </br>
                                        <font color="red">${requestScope.ERROR.passwordIsEmptyError}</font>
                                    </c:if> 
                                </td>
                                <td>
                                    <input type="text" name="txtHiddenFullname" value="${dto.fullName}" />
                                    <c:if test="${not empty requestScope.ERROR.fullnameIsEmptyError and requestScope.ERROR_PK == dto.username}" >
                                        </br>
                                        <font color="red">${requestScope.ERROR.fullnameIsEmptyError}</font>
                                    </c:if>
                                </td>
                                <td>
                                    <input type="checkbox" name="isDisable" value="ON" 
                                           <c:if test="${dto.disable}">
                                               checked="checked"
                                           </c:if>
                                           />
                                </td>
                                <td>
                                    <c:url var="urlRewriting" value="DispatchServlet">
                                        <c:param name="btnAction" value="DeleteAccount"/>
                                        <c:param name="pk" value="${dto.username}"/>
                                        <c:param name="lastSearchValue" value="${searchValue}"/>
                                    </c:url>
                                    <a href="${urlRewriting}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="UpdateAccount" name="btnAction" />
                                    <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty result}">
            No search found
        </c:if>
    </c:if>
</body>
</html>
