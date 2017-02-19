<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/shared/header.jsp"%>
<hr>
<div class="container">
    <h1>Products Page</h1>
    <p>Welcome to the products page. This is the page where all the products will be listed.
       Check the products available in the table below.</p>
<hr>
    <table class="table table-responsive table-bordered">
        <thead>
            <tr>
                <td></td>
                <td>Product Name</td>
                <td>Product Description</td>
                <td>Product Manufacturer</td>
                <td>Product Price</td>
                <td>Product Stock</td>
                <td>Product Details</td>
            </tr>
        </thead>
        <c:forEach var="product" items="${products}">
        <tbody>
            <tr>
                <td><img src="http://placehold.it/200x100" alt="images" class="img-responsive"></td>
                <td>${product.productName}</td>
                <td>${product.productDescription}</td>
                <td>${product.productManufacturer}</td>
                <td>${product.productPrice}</td>
                <td>${product.productStock}</td>
                <td><a href="<spring:url value="/product/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign" ></span></a></td>
            </tr>
        </tbody>
        </c:forEach>
    </table>
</div>





<%@include file="/WEB-INF/views/shared/footer.jsp"%>
