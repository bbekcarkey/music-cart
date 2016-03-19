<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templete/header.jsp" %>>



<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">

   <div class="container">
        <div class="page-header">
                <h1> All products</h1>

                <p class="lead">Check out all the aweome product</p>
                </div>

<table class="table table-striped table-hover">
<thead>
<tr class="bg-success">
        <th>Photo thumb</th>
        <th>Product Name</th>
        <th>Category</th>
        <th>Condition</th>
        <th>Price</th>
        
        </tr>
</thead>
 <c:forEach items="${products}" var="product">
<tr>
        <td><img src="#" alt="image"/></td>
        <td>${product.productName}</td>
        <td>${product.productCategory}</td>
        <td>${product.productCondition}</td>
        <td>${product.productPrice}USD</td>
        <td class="active"><a href="<c:url value="/productlist/viewProduct/${product.productId}"/>">Info</a></td>
              
</tr>
</c:forEach>
</table>

<%@include file="/WEB-INF/views/templete/footer.jsp" %>