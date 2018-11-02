<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h3 align="center">Product Page</h3>
<div class="container-fluid">
	   <table class="table table-bordered">
<tr>
		<td rowspan="7">
		<img src="<c:url value="/resources/img/${ProductInfo.productId}.jpg"/>" width="200" height="200"/>
		</td>
		<td>Product ID</td>
		<td>${ProductInfo.productId}</td>
	</tr>
	<tr>
		<td>Price</td>
		<td>${ProductInfo.productPrice}</td>
	</tr>
	<tr>
		<td>Product Name</td>
		<td>${ProductInfo.produtName}</td>
	</tr>
	<tr>
		<td>Category ID</td>
		<td>${ProductInfo.categoryId}</td>
	</tr>
	<tr>
		<td>Supplier ID</td>
		<td>${ProductInfo.supplierId}</td>
	</tr>
	<tr>
		<td>Product Description</td>
		<td>${ProductInfo.produtDesription}</td>
	</tr>
	<c:if test="${not empty SuccessMessage}">
       <td><form action="<c:url value="/addToCart/${ProductInfo.productId }"/>" method="post">
        </c:if>
        <c:if test="${empty SuccessMessage}">
        <td><form action="<c:url value="/login"/>">
         </c:if>
       	<tr>
		<td>Quantity</td>
		<td>
		<select name="quantity">                    
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
		</td>
		<td><c:if test="${empty SuccessMessage}">
	  <button class="btn btn-primary">login to add to cart
	     </c:if> 
		<c:if test="${not empty SuccessMessage}">
		<input type="submit" value="AddToCart" class="btn btn-success"></c:if>
	    </td>
</tr>
</form>
</table>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>