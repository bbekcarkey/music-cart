<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templete/header.jsp" %>>



<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">

   <div class="container">
        <div class="page-header">
                <h1>Product Detail</h1>

                <p class="lead">Here is the Detail Information of the product</p>
                </div>
<div class="container">
<div class="row">

<div class="col-ad-5">

<img src="#" alt="image" style="width: 219px; heigth:300px; height: 113px" /><p align="left">
</p></div>

<div class="col-ad-5">
<h3>Product Name:${product.productName} </h3>
<p>Product Description:${product.productDescription}</p>
<p>Manufacturer:${product.productManufacturer}</p>
<p>Category:${product.productCategory}</p>
<p>Condition:${product.productCondition}</p>
<p>Price:${product.productPrice}USD</p>
</div>

</div>



</div>


<%@include file="/WEB-INF/views/templete/footer.jsp" %>>
  