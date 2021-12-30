<%@page import="sis.com.bo.User" %>

<html>
	<head>
	    
		<title>Customer home</title>
		
		
 <link href="style.css"  rel="stylesheet">

 
<style type="text/css">
	body{
		background-image:url(car.jpg);
		background-size: cover;
		background-position: center;
	}
	
	.input-gap{
	margin: 5px 0px;
}
	
</style>

	</head>

<body  >

<%
 User user=null;
 if(session.getAttribute("user")!=null){
	 user  =(User) session.getAttribute("user");
 }
 %>


<!--start header-->
<div id="sis_header">
	<!--start header  top-->
       <div style="height:100px;">
			<!--start header  top logo-->
			<div style="height:100px;float:left;width:10 %;border-radius: 60px;">
			<center>
			<img src="logo.png" width="100" height="100" style="border-radius: 53px;">
			</center>
			</div>
			<!--end header  top logo-->
			<!--start header  top project-->
			<div style="height:100px;float:left;width:60%;">
			<center>
			  <h1 style="font-size: 75px; color:white; margin-top:14px; margin-left:-507px;"> 
			  Cars4u</h1>
			  </center>
			 <!--  
			  <marquee behavior="alternate" scrollamount="10">Cars4u
			  </marquee>
			  -->
			  
			
			</div>
			<!--end header  top project-->
			<!--start header  top login-->
			<div style="background-color:baf2ba;height:100px;float:left;width:20%;">
			  <%=user.getName() %>
			</div>
			<!--end header  top login-->
		   
	   </div>
	<!--end header  top-->
	<!--start header bottom-->
       <div style="height:50px;">
		<ul>
		<!-- Home link in active mode.. -->
			<li><a href="home.jsp">Home</a></li>
			<li><a href="#" >Add Vehicle</a></li>
			<li><a href="viewvehicleadmin" >View Vehicle</a></li>
			<li><a href="#" >View Request</a></li>
			<li><a href="#" >View Return</a></li>
			<li><a href="#" >Logout</a></li>
						
		</ul>	
       
	   </div>
<!--end header bottom--> 
 </div> 
<!--end header-->

<div>
    <center>
         
 <fieldset style="width: 30%; height: 40%;"><legend> <strong> Add Vehicle</strong></legend>
    <!-- <%
    String userEmail= "";
    if(session.getAttribute("userEmail")!=null){
        userEmail  =(String) session.getAttribute("userEmail");
    }
    %> -->
    <!-- <form action="signup_controller.jsp" method="post"> -->
    <form action="addvehicle" method="post"> 
     
    Vehicle_type: <input class="
    input-gap" name="vehicle_type"  required="required"><br> 
    Vehicle_Name: <input class="
    input-gap" name="vehicle_name"    required="required"><br> 
    Vehicle_No: <input class="
    input-gap" name="vehicle_no"    required="required"><br> 
    Capacity: <input class="
    input-gap" name="vehicle_capacity"    required="required"><br> 
    Cost/day: <input class="
    input-gap" name="vehicle_cost"     required="required"><br> 

    <input class="loginbuton" type="submit" value="Add" >
   </form>
    </fieldset>
    </center>
</div>








<%@include file="footer.jsp"%> 