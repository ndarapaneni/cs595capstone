<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" import="data.*" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
      <title>PatientList</title>    
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
h4{
<br>
align:center;
padding:10px;
margin-left: 150px;
}
h5{
text-align : center;
width:1200px;
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

table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding:10px;
    margin-left: 150px;
    
}
th, td {
    padding: 10px;
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
<% 
   //ArrayList<Department> deptList = (ArrayList<Department>) request.getSession().getAttribute("departmentList");

%>

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
  <br>
  <br>
  <h4> Device Details List:</h4>
<c:choose>
    <c:when test='${detailsList == null || empty detailsList}'>
         No patients available at this time
    </c:when>
    <c:otherwise>
      
      <table>
		<tr><td>DeviceId</td><td>AccX</td><td>AccY</td><td>AccZ</td><td>GyroX</td><td>GyroY</td><td>GyroZ</td><td>RiskLevel</td><td>PatientId</td>
		
		
      <c:forEach items="${detailsList}" var="device">
<tr><td>${device.deviceId}</td><td>${device.accX}</td><td>${device.accY}</td><td>${device.accZ}</td><td>${device.gyroX}</td><td>${device.gyroY}</td><td>${device.gyroZ}</td><td>${device.riskLevel}</td><td>${device.patientId}</td>
      </c:forEach>
      </table>
      
    </c:otherwise>
    </c:choose>


<br>
<ul>
	<li><a href="services.jsp">Back to home page</a></li><br><br>
	<li><a href="./LogoutServlet">Logout</a></li>
	</ul>
	
	
	<h5> <b>Copyright@npu.edu <b> </h5>
	</div>
	<br>
<br>
<div id="footer">
</div>
</body>
</html>