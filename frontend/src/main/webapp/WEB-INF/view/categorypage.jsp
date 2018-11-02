<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<style type="text/css">
.background
{
   height: 800px;
   background-image: url("http://www.winwallpapers.net/w1/2015/07/Kentucky-Fried-Chicken-Wallpaper.jpg");
   background-repeat: no-repeat;
   background-size: 100%;
}
</style>

<body>
 <%@include file="Header1.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3 align="center">Category Page</h3>

<div class="container">
    <form class="form-inline" action="InsertCategory" method="post">
    <div class="form-group">
      <label for="text">Category Name:</label>
      <input type="text" class="form-control" id="catname" placeholder="Enter category name" name="catname">
    </div>
    <div class="form-group">
      <label for="text">Category Description:</label>
      <input type="text" class="form-control" id="catdesc" placeholder="Enter category description" name="catdesc">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>&nbsp
    <button type="reset" class="btn btn-default">Reset</button>
  </form>
</div>

<br><br>
<div class="container">
	   <table class="table table-bordered">
	   <thead>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Description</td>
		<td>Operation</td>
       </thead>
	<c:forEach items="${listCategories}" var="category">
		<tr>
			<td>${category.categoryId}</td>
			<td>${category.categoryName}</td>
			<td>${category.categoryDescription}</td>
			<td><a
				href="<c:url value="/updateCategory/${category.categoryId}"/>">Update</a>
				<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>
</div>
 <%@include file="footer.jsp" %>
</body>
</html>