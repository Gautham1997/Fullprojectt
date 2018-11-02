<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

* {
    box-sizing: border-box;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 10px;
}

/* Create two columns that float next to eachother */
.column {
    float: left;
    width: 50%;
    margin-top: 6px;
    padding: 20px;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

@media screen and (max-width: 600px) {
    .column, input[type=submit] {
        width: 100%;
        margin-top: 0;
    }
    
    .back
{
   height: 700px;
   background-image: url("https://upload.wikimedia.org/wikipedia/commons/6/63/2k16_MZ_logo_reduced_resolution.png");
   background-repeat: no-repeat;
   background-size: 50%;
   
   background-position:center;
}
    
    
}
</style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
<div class="row">
   <center> <h2>About Us</h2>
    <p>We provide some important information about our product...!</p></center>
  
    <div class="col-lg-6 col-sm-12 left">
    <div class="back">
   <center> <img src="C:\Users\USER\Desktop\img\comLOG.png" alt="CompanyImage" style="width:100%;"></center>
    </div>
    </div>
     <div class="col-lg-6 col-sm-12 right">
     <br><br> <p><b>Address: Celestial Centre, NIIT T Nagar, No. 33, S Usman Road, T Nagar, Chennai,Tamil Nadu 600017</b></p>
              <p><b>Contact person for Customer: 044 4550 6302</b></p>  
              <p><b>Contact person for Supplier:  099419 28222</b></p>
              <br><br>  
    </div>
    </div>
    </div>
<%@ include file="footer.jsp" %>
</body>
</html>