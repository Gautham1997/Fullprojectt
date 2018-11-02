<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <!--   <style type="text/css">
  .background
{
   height: 800px;
   background-image: url("resources/images/background1.jpg");
   background-repeat: no-repeat;
   background-size: 100%;
}
</style>-->
  </head>
  <body>
  <%@include file="header.jsp" %>
<div class="container"> 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="G:\New folder\frontend\src\main\webapp\images\c1.jpg" alt="SMOOKY CHICKEN" style="width:100%;">
      </div>

      <div class="item">
        <img src="G:\New folder\frontend\src\main\webapp\images\c2.jpg" alt="FRIED CHICKEN" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="G:\New folder\frontend\src\main\webapp\images\c3.jpg" alt="New york" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<%@include file="footer.jsp" %>
</body>
  
</html>
