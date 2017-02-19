<%@include file="/WEB-INF/views/shared/header.jsp"%>

<div class="container">
        <hr>
        <div>
            <h1>Product Page</h1>
            <p>You can view the description of any given product below</p>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-5">
                <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" style="width:100%" alt="images" class="img-responsive"></td>
            </div>
            <div class="col-md-7">
                <p><strong>Product Name:</strong> ${product.productName}</p>
                <p><strong>Product Description:</strong> ${product.productDescription}</p>
                <p><strong>Product Manufacturer:</strong >${product.productManufacturer}</p>
                <p><strong>Product Price:</strong> Rs.${product.productPrice}</p>
                <p><strong>Product Stock:</strong> ${product.productStock}</p>
            </div>
        </div>
</div>


<%@include file="/WEB-INF/views/shared/footer.jsp"%>