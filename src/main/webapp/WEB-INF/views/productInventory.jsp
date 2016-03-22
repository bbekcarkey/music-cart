<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templete/header.jsp" %>



<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">

   <div class="container">
        <div class="page-header">
                <h1> Product Inventory</h1>

                <p class="lead">Here you can add and delete product</p>
                </div>

<table class="table table-striped table-hover">
<thead>
<tr class="bg-success">
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Category</th>
        <th>Condition</th>
        <th>Price</th>
        <th></th>
        <th></th>
        
        </tr>
</thead>
 <c:forEach items="${products}" var="product">
<tr>
        <td>${product.productId}</td>
        <td>${product.productName}</td>
        <td>${product.productCategory}</td>
        <td>${product.productCondition}</td>
        <td>${product.productPrice}USD</td>
        <td class="active"><a href="<c:url value="/productlist/viewProduct/${product.productId}"/>">Info</a></td>
        <td class="active"><a href="<c:url value="/admin/productInventory/deleteProduct${product.productId}"/>">Delete</a></td>
              
</tr>
</c:forEach>
</table>
<a href="<c:url value="/admin/productInventory/addProduct"/>" class="btn btn-primary"    >Add Product</a>


<%@include file="/WEB-INF/views/templete/footer.jsp" %>