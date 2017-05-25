<%-- 
    Document   : logout
    Created on : Mar 27, 2017, 7:35:12 PM
    Author     : Welcome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.setAttribute("user", null);
        %>
        You have logged out Successfully , To Re-login click
        <a href="index.jsp?shw=Login">here</a>
    </body>
</html>
