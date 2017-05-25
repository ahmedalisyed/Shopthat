<%-- 
    Document   : Product
    Created on : Apr 10, 2017, 7:28:15 PM
    Author     : Welcome
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="add">
                <form action="Product?m=c" method="post" >
                    <fieldset style="width:300px;text-align: center;">
                        <legend>Product</legend>
                        <input type="text" name="name" placeholder="Product Name" value="${product.name}" /><br/><br/>
                        <textarea name="description" rows="4" cols="20" placeholder="Product Description">${product.description}</textarea><br/><br/>
                        <input type="number" name="price" placeholder="Product Price" value="${product.price}" /><br/><br/>
                        <select name="categoryId">
                            <c:if test="${not empty category}">
                                <option value="${category.id}">${category.name}</option>
                            </c:if>
                            <c:forEach var="c" items="${categories}">
                                <option value="${c.id}">${c.name}</option>
                            </c:forEach>
                        </select><br/><br/>
                        <input type="text" name="manufacturename" placeholder="Manufacture Name" value="${product.manufacturename}" /><br/><br/>
                        <c:if test="${empty product}">
                            <input type="submit" value="Add Product" />
                        </c:if>
                        <c:if test="${not empty product}">
                            <input type="submit" value="Update Product" formaction="Product?m=u&&id=${product.id}"/>
                        </c:if>
                    </fieldset>
                </form>
            </div><br/>
            <div id="view">
                ${products}
                <table border="1" align='center'>
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Description</th>
                            <th>MRP</th>
                            <th>Category</th>
                            <th>Manufacture</th>
                            <th>Edit</th>
                            <th>Delete</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var='p' items="${products}">
                        <tr>
                            <td>${p.name}</td>
                            <td>${p.description}</td>
                            <td>$
                                {p.price}</td>
                            <td>${p.categoryId}</td>
                            <td>${p.manufacturename}</td>
                            <td><a href="Product?m=e&&id=${p.id}"> edit </a></td>
                            <td><a href="Product?m=d&&id=${p.id}"> X </a></td>
                            <td><a href='Products?id=${p.id}'>View Products</a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
    </body>
</html>
<%@include file="footer.jsp" %>