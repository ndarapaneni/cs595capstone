<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
   <script src="./script.js"></script>
<title>Registration</title>
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
<body>
<div id="header" >
<h1>      Secure Arm      </h1>
</div>
<div id="nav" style = "text-align: center">
<ul >
    
	<li><a href="searchpatient.jsp">SearchPatient</a></li>
	<li><a href="./LogoutServlet">Logout</a></li>
	<li><a href="./PatientListServlet">PatientList</a></li>
	<li><a href="./DeviceDetailServlet">deviceList</a></li>
	<br><br>
</ul>
</div>
<div id="section">
<div id="myGallery">
 <img src="images/img.jpg" class="active" />
   
    <img src="images/img3.jpg"  width="500px";height="500px" align="center"/>
    <img src="images/img4.jpg"  width="500px";height="700px"  align="center"/><br><br>
  </div>
  <div class="container">
<div class="form-group">
<h2>Enter Information Here</h2>
<form  method="post" action="./RegisterServlet">

<label >First Name: </label>
<input class="form-control" type="text" name="firstname" id="firstname"><br>
<label id="firstnameerror" class="error" ></label>
<label>Last Name: </label>
<input class="form-control" type = "text" name = "lastname"><br>
<label>Email Id: </label>
<input class="form-control" type="email" name="emailid"><br>
<label>Password: </label>
<input class="form-control" type = "Password" name = "password"><br>
<label>TelPhone: </label>
<input class="form-control" type = "text" name = "phonenumber"><br>
<label>Type: </label>
<input class="form-control" type = "text" name = "type"><br>
<input   class ="btn-primary" type="submit" name="submit" value="submit" ;">
<input   class ="btn-primary" type="Reset" name="Reset" value="Reset" ><br><br>
        </form>
<label >Already registered!!</label><br>
		<ul>
    <li><a href="login.jsp">Login Here</a></li>
    </ul>
	</div>
	</div>
	</div>
    </body>
</html>