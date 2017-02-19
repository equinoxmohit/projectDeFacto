<%@include file="/WEB-INF/views/shared/header.jsp"%>

<div class="container">
    <div>
        <h1>Add Products</h1>
        <p>Fill the form below to add new products</p>
    </div>
    <div>
        <form:form commandName="product" method="post" action="${pageContext.request.contextPath}/admin/addproduct">
            <div class="form-group">
            <label for="name">Product Name</label>
             <form:input path="productName" id="name" class="form-control"/>
            </div>
            <div class="form-group">
            <label for="description">Product Description</label>
            <form:textarea path="productDescription" id="description" class="form-control"/>
            </div>
            <div class="form-group">
            <label for="manufacturer">Product Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-control"/>
            </div>
            <div class="form-group">
            <label for="price">Product Price</label>
            <form:input path="productPrice" id="price" class="form-control"/>
            </div>
            <div class="form-group">
            <label for="stock">Product Stock</label>
            <form:input path="productStock" id="stock" class="form-control"/>
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