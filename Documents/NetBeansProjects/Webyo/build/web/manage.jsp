<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : manage
    Created on : Apr 7, 2017, 7:41:22 PM
    Author     : Welcome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .content,#add{
                width: 80%;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="content">
            <c:if test="${not empty user}">
                    <c:if test="${user.roles[1].roleName eq 'Seller' or user.roles[2].roleName eq 'Seller' }">
                        <%@include file="ProductDetails.jsp" %>
                    </c:if>
                    <c:if test="${user.roles[1].roleName=='Admin' or user.roles[2].roleName=='Admin' }">
                        <%@include file="Category.jsp" %>
                    </c:if>
             </c:if>
        </div>
    </body>
</html>
<%@include file="footer.jsp" %>