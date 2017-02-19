
<%@include file="/WEB-INF/views/shared/header.jsp"%>
<!-- /.intro section -->
<div id="intro">
    <div class="container">
        <div class="row">

            <!-- /.intro image -->
            <div class="col-md-6 intro-pic wow slideInLeft">
                <img src="http://placehold.it/1000x556" alt="image" class="img-responsive">
            </div>

            <!-- /.intro content -->
            <div class="col-md-6 wow slideInRight">
                <h1>Main Landing Page</h1>
               <p>Welcome to the index page. This is a site where you can get listing of the product along with the description of the site</p>

                <div class="btn-section"><a href="<c:url value="/products"/> " class="btn-default">View Products</a></div>

            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/shared/footer.jsp"%>