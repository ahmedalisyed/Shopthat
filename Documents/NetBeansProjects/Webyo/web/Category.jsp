<%-- 
    Document   : Category
    Created on : Apr 10, 2017, 7:26:00 PM
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
        <div id="add">
                <form action="Category?m=c" method="post" >
                    <fieldset style="width:300px;text-align: center;">
                        <legend>Category</legend>
                        <input type="text" name="name" placeholder="Category Name" value="${category.name}" /><br/><br/>
                        <textarea name="description" rows="4" cols="20" placeholder="Category Description">${category.description}</textarea><br/><br/>
                        <c:if test="${empty category}">
                            <input type="submit" value="Add Category" />
                        </c:if>
                        <c:if test="${not empty category}">
                            <input type="submit" value="Update Category" formaction="Category?m=u&&id=${category.id}"/>
                        </c:if>
                    </fieldset>
                </form>
            </div><br/>
            <div id="view">
                <table border="1" align='center'>
                    <thead>
                        <tr>
                            <th>Category</th>
                            <th>Description</th>
                            <th>Edit</th>
                            <th>Delete</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var='c' items="${categories}">
                        <tr>
                            <td>${c.name}</td>
                            <td>${c.description}</td>
                            <td><a href="Category?m=e&&id=${c.id}"> edit </a></td>
                            <td><a href="Category?m=d&&id=${c.id}"> X </a></td>
                            <td><a href='Product?m=s&&id=${c.id}'>View Products</a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>   
    </body>
</html>