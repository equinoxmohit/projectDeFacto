<%@include file="/WEB-INF/views/shared/header.jsp"%>

<div class="container">
    <div>
        <h1>Update Products</h1>
        <p>Fill the form below to add new products</p>
    </div>
    <div>
        <form:form commandName="product" method="post" action="${pageContext.request.contextPath}/admin/updateproduct/" enctype="multipart/form-data">
            <form:hidden path="productId" value="${product.productId}"/>
            <div class="form-group">
                <label for="name">Product Name</label>
                <form:errors path="productName" cssStyle="color: firebrick"/>
                <form:input path="productName" id="name" value="${product.productName}" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="description">Product Description</label>
                <form:errors path="productDescription" cssStyle="color: firebrick"/>
                <form:textarea path="productDescription" id="description" value="${product.productDescription}" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="manufacturer">Product Manufacturer</label>
                <form:errors path="productManufacturer" cssStyle="color: firebrick"/>
                <form:input path="productManufacturer" id="manufacturer" value="${product.productManufacturer}" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="price">Product Price</label>
                <form:errors path="productPrice" cssStyle="color: firebrick"/>
                <form:input path="productPrice" id="price" value="${product.productPrice}" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="stock">Product Stock</label>
                <form:errors path="productStock" cssStyle="color: firebrick"/>
                <form:input path="productStock" id="stock" value="${product.productStock}" class="form-control"/>
            </div>
            <div>
                <label class="control-label" for="image">Product Image</label>
                <form:input path="productImage" id="image" type="file" class="form:input-large"/>
            </div>
            <br>
            <div>
                <input type="submit" value="submit" class="btn btn-success"/>
                <a href="/admin?cancel" class="btn btn-danger">Cancel</a>
            </div>
        </form:form>
    </div>
</div>

<%@include file="/WEB-INF/views/shared/footer.jsp"%>
