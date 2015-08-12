<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
          
<title>Services</title>
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
#section {
    width:350px;
    float:left;
    padding:10px;	 	 
}
#footer {
    
    background-image:url("images/social.png");
    background-repeat: no-repeat;
    color:#003b6f;
    margin-top: 600px;
    padding:10px;
    margin-left: 270px;
    text-align: center;
    width:1500px;
    height:100px;
    margin-bottom: 10px;
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
body{

background-image:url("images/backgroundBorder.jpg");
background-repeat: repeat;
}
h2{
<br>
align:center;
}
h5{
text-align : center;
width:600px;
height:100px;
margin-bottom: 10px;

}
#content{
text-align : center;
border-top : 100px;
border-left: 50px;
padding-left: 400px;
padding-top:100px;
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
  <div id="content">
<h2>AboutUs</h2>
<p style=" width:600px;  align:justify;">
Fallarm is a project originated by QIRIS Quality Innovation Research Instruction Safety, 
a non-profit association whose objective is to foster scientific research and technological 
innovation for person centered health-care. QIRIS has developed fallarm, a technological 
solution for fall prevention. Fallarm is based on a wearable device that informs the patient
in situations where the risk is higher, promoting users’ awareness on their responsible
mobility QIRIS: Quality Innovation Research Instruction Safety
 </p>
 <h5> <b>Copyright@npu.edu <b> </h5>
 </div>
</div>
<div id="footer">
</div>
</body>
</html>