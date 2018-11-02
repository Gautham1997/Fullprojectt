<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<title>update category</title>
</head>
<style type="text/css">
.background
{
   height: 800px;
   background-image: url("G:\New folder\frontend\src\main\webapp\images\b2.jpg");
   background-repeat: no-repeat;
   background-size: 100%;
}
</style>
<%@include file="Header1.jsp" %>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="background">
<h4 align="center">Category Updation</h4>
<div class="container">
    <form class="form-horizontal" action="<c:url value="/UpdateCategory"/>" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Category ID:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" readonly id="catid" name="catid" value="${categoryInfo.categoryId}"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Category Name:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="catname" name="catname" value="${categoryInfo.categoryName}"/>
    </div>
  </div>
	
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Category Description:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="catdesc" name="catdesc" value="${categoryInfo.categoryDescription}"/>
    </div>
  </div>
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
      <button type="submit" class="btn btn-default">Reset</button>
    </div>
  </div>
	
	</form>
	</div>
	
	
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
		<td>
		<a href="<c:url value="/updateCategory/${category.categoryId}"/>">Update</a>/
		<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>
</div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>