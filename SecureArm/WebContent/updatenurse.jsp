<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" import="domain.Nurse" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Update Nurse Details</title>
<style>
#header {
    background-image:url("images/header.jpg");
    background-repeat: no-repeat;
    color:#003b6f;
    margin-top: 25px;
    padding:10px;
    margin-left: 150px;
    text-align: center;
    width:100%;
}
#nav ul li {
    list-style:none;
   	 
    margin-left: 100px;
}

a{
text-decoration:none;
float:left;
height:40px;
line-height:40px;
padding:0 10px;
margin-left:1cm;
border-top-left-radius:8px;
border-top-right-radius:8px;
font-size:20px;
font-family:arial, verdana, sans-serif;
background-color:#12aa21;
color: #FF9900;
align:center;
}
a:hover{
background-color:#99FF66;
}
body{

background-image:url("images/backgroundBorder.jpg");
background-repeat: repeat;
}
#myGallery{
      position:relative;
      margin-left:400px;
      width:400px; /* Set your image width */
      height:300px; /* Set your image height */
    }
    #myGallery img{
      display:none;
      position:absolute;
      top:0;
      left:0;
      bottom: 50px;
    }
    #myGallery img.active{
      display:block;
    }
    #section {
    width:350px;
    float:left;
    padding:10px;
     
    margin-left: 150px;	 	 
}
</style>
<script>
 function swapImages(){
     var $active = $('#myGallery .active');
     var $next = ($('#myGallery .active').next().length > 0) ? $('#myGallery .active').next() : $('#myGallery img:first');
     $active.fadeOut(function(){
     $active.removeClass('active');
     $next.fadeIn().addClass('active');
     });
   }

   $(document).ready(function(){
     // Run our swapImages() function every 5secs
     setInterval('swapImages()', 5000);
   });
 
      </script>
</head>
<body > 
<div id="header" >
<h1>      Secure Arm      </h1>
</div>
<div id="nav" style = "text-align: center">
<ul >
    
	<li>  <a href="searchpatient.jsp">SearchPatient</a> </li>
<li>  <a href="updatenurse.jsp">updateNurse</a> </li>


<li>  <a href="./LogoutServlet">Logout</a> </li>
<li>  <a href="./PatientListServlet">PatientList</a> </li>
<li>  <a href="./DeviceDetailServlet">deviceList</a> </li>
<li>  <a href="./NurseListServlet">nurseList</a> </li>
	<br><br>
</ul>
</div>
<div id="section">
<div id="myGallery">
 <img src="images/img.jpg" class="active" />
   
    <img src="images/img3.jpg"  width="500px";height="500px" align="center"/>
    <img src="images/img4.jpg"  width="500px";height="700px"  align="center"/><br><br>
  </div>
<br><br>
<br><br>
<div class="container">
<div class="form-group">
<form name= "updateemail" method = "post" action = "./UpdateNurseServlet">
	<h2>Enter details to update: </h2>
	<label >DeviceId: </label>
	
	<input class="form-control" type = "text" name = "deviceid"><br>
	<label >NurseEmail: </label>
	<input class="form-control" type = "email" name = "nurseemail">
	
<br><br>
<input class ="btn-primary" type = "submit" name = "Submit" value = "Submit"><br><br>
</form>

<ul>
	<li><a href="services.jsp">Back to home page</a></li><br><br>
	<li><a href="./LogoutServlet">Logout</a></li>
	</ul>
	<br>
	</div>
	</div>
	</div>
	
</body>
</html>