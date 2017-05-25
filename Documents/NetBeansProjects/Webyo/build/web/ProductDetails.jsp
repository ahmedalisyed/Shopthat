<%-- 
    Document   : ProductDetails
    Created on : Apr 10, 2017, 7:30:00 PM
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
                <form action="ProductDetails?m=c" method="post" >
                    <fieldset style="width:300px;text-align: center;">
                        <legend>Product Details</legend>
                        <input type="text" name="serialNumber" placeholder="Serail Number" value="${productDetail.serialNumber}" /><br/><br/>
                        <input type="date" name="manufactureDate" placeholder="Manufacture Date" value="${productDetail.manufactureDate}" /><br/><br/>
                        <input type="date" name="expiryDate" placeholder="Expiry Date" value="${productDetail.expiryDate}" /><br/><br/>
                        <input type="text" name="size" placeholder="Size" value="${productDetail.size}" /><br/><br/>
                        <input type="text" name="color" placeholder="Color" value="${productDetail.color}" /><br/><br/>
                        <input type="text" name="sellerId" placeholder="seller" value="${user.id}" readonly/><br/><br/>
                        <select name="productId">
                            <c:if test="${not empty productDetail}">
                                <option value="${productDetail.serialNumber}">${productDetail.name}</option>
                            </c:if>
                            <c:forEach var="p" items="${products}">
                                <option value="${p.id}">${p.name}</option>
                            </c:forEach>
                        </select><br/><br/>
                        <c:if test="${empty product}">
                            <input type="submit" value="Add Product Details" />
                        </c:if>
                        <c:if test="${not empty product}">
                            <input type="submit" value="Update Product Details" formaction="Product?m=u&&id=${product.id}"/>
                        </c:if>
                    </fieldset>
                </form>
            </div><br/>
            <div id="view">
                <table border="1" align='center'>
                    <thead>
                        <tr>
                            <th>Product Serail Number</th>
                            <th>Product Id</th>
                            <th>Mafc. Date</th>
                            <th>Expy. Date</th>
                            <th>Size</th>
                            <th>Color</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var='p' items="${productDetails}">
                        <tr>
                            <td>${p.serialNumber}</td>
                            <td>${p.productId}</td>
                            <td>${p.manufactureDate}</td>
                            <td>${p.expiryDate}</td>
                            <td>${p.size}</td>
                            <td>${p.color}</td>
                            <td><a href="ProductDetails?m=e&&id=${p.serialNumber}"> edit </a></td>
                            <td><a href="ProductDetails?m=d&&id=${p.serialNumber}"> X </a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
    </body>
</html>