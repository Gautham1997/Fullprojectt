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

/* Style inputs */
input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

/* Style the container/contact section */
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

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
    .column, input[type=submit] {
        width: 100%;
        margin-top: 0;
    }
}
</style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
  <div style="text-align:center">
    <h2>Contact Us</h2>
    <p>Swing by for a cup of coffee, or leave us a message:</p>
  </div>
  <div class="row">
    <div class="column">
      <div id="map" style="width:100%;height:500px"></div>
    </div>
    <div class="column">
     <br><br> <p><b>Address: Celestial Centre, NIIT T Nagar, No. 33, S Usman Road, T Nagar, Chennai,Tamil Nadu 600017</b></p>
              <p><b>Contact person for Customer: 044 4550 6302</b></p>  
              <p><b>Contact person for Supplier:  099419 28222</b></p>
              <br><br>
              <p><a href="https://www.facebook.com/sargunanraman92"><img src="https://cdn1.iconfinder.com/data/icons/logotypes/32/square-facebook-512.png" width="60" height="60"/></a> &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="mailto:sargunanraman@gmail.com"><img src="https://cdn1.iconfinder.com/data/icons/logotypes/32/square-google-plus-512.png" width="60" height="60"/></a> &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="https://www.blogger.com/profile/14587656687219601487"><img src="https://cdn1.iconfinder.com/data/icons/logotypes/32/blogger-512.png" width="60" height="60"/></a> &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="https://www.linkedin.com/in/sargunanraman07/"><img src="https://cdn1.iconfinder.com/data/icons/logotypes/32/square-linkedin-512.png" width="60" height="60"/></a> &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="https://www.youtube.com/watch?v=ryUctWmqVlc"><img src="https://cdn1.iconfinder.com/data/icons/logotypes/32/youtube-512.png" width="80" height="80"/></a> &nbsp;&nbsp;&nbsp;&nbsp;
              </p>
    </div>
  </div>
</div>

<script>
// Initialize google maps
function myMap() {
  var myCenter = new google.maps.LatLng(51.508742,-0.120850);
  var mapCanvas = document.getElementById("map");
  var mapOptions = {center: myCenter, zoom: 12};
  var map = new google.maps.Map(mapCanvas, mapOptions);
  var marker = new google.maps.Marker({position:myCenter});
  marker.setMap(map);
  
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>
<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->
<%@ include file="footer.jsp" %>
</body>
</html>