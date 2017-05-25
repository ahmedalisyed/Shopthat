<%--
    Document   : Hello
    Created on : Mar 22, 2017, 7:27:40 PM
    Author     : Welcome
--%>


<%@page import="com.webyo.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <%@include file="header.jsp" %>
        <c:if test="${empty user}">
            <% response.sendRedirect("index.jsp?shw=Login"); %>
        </c:if>
        <div class='content'>
            
            
            
            <%
                Cookie[] cookies=request.getCookies();
                for(Cookie c:cookies){
                    if(c.getName().equals("mail")){
                        out.println(c.getValue());
                    }
                }
            %>
           <c 
        </div>
            <%@include file="footer.jsp" %>
    </body>
</html>