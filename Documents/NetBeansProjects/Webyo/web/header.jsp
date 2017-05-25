<%-- 
    Document   : header
    Created on : Mar 30, 2017, 7:23:18 PM
    Author     : Welcome
--%>
<%@page import="com.webyo.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-shop</title>
        <style>
            .header{
                width: 100%;
                height: 50px;
                background-color: Orange;
                font-size: 50px;
                text-align: center;
                color: blue;
                padding: 15px 0px 15px 0px;
            }
            .content{
                width: 100%;
            }
            .footer{
                width: 100%;
                height: 30px;
                background-color: Orange;
                position: fixed;
                bottom: 0px;
                text-align: center;
                color: blue;
            }
            nav{
                background-color: brown;
                height: 30px;
                text-align: center;
            }
            nav a{
                font-size: 15px;
                background-color: wheat;
                padding: 5px 45px 5px 45px;
            }
            #About,#Contact,#Feedback{
                width: 100%;
                height:300px;
            }
            .Logged{
                font-size: 15px;
                color: black;
                top:0px;
                right: 10px;
                position: absolute;
            }
        </style>
    </head>
    <body>
        <div class='header'>
            Webify
            
        </div>
            <nav>
                <a href='index.jsp#Home'>Home</a>
                <a href='index.jsp#About'>About Us</a>
                <a href='index.jsp#Contact'>Contact Us</a>
                <a href='index.jsp#Feedback'>Feedback</a>
                
                <c:if test="${empty user and empty param.shw}">
                    <a href='index.jsp?shw=Login'>Login</a>
                </c:if>
                <c:if test="${empty user and not empty param.shw}">
                    <a href='index.jsp'>Sign Up</a>
                </c:if>
                <c:if test="${not empty user}">
                   <c:if test="${user.roles[1].roleName eq 'Seller' or user.roles[2].roleName eq 'Seller' }">
                        <a href='manage.jsp'>Manage Store</a>
                    </c:if>
                    <c:if test="${user.roles[1].roleName=='Admin' or user.roles[2].roleName=='Admin' }">
                        <a href='manage.jsp'>Manage Site</a>
                    </c:if>
                        <a href='logout.jsp'>Logout</a>
                        <p class="Logged">Hi ${user.firstName} ${user.lastName} !! <br/><i>You are logged in as ${param.r}</i></p>
                </c:if>
            </nav>
    </body>
</html>
