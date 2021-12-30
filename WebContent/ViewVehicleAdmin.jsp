<%@page import="sis.com.bo.Vehicle" %>
<%@page import="sis.com.bo.User" %>
<%@page import="java.util.List"%>

<html>
	<head>
	    
		<title>ViewVehicle1</title>
		
		
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
			<li><a href="addvehicle" >Add Vehicle</a></li>
			<li><a href="#" >View Vehicle</a></li>
			<li><a href="#" >View Request</a></li>
			<li><a href="#" >View Return</a></li>
			<li><a href="#" >Logout</a></li>
						
		</ul>	
       
	   </div>
<!--end header bottom--> 
 </div> 
<!--end header-->


  <% 
String addMsg = request.getParameter("add_msg");
  String deleteMsg = request.getParameter("delete_msg");
  String updateMsg = request.getParameter("update_msg");

if(addMsg!=null ){ %>
<fieldset>
  <h1>
  Add msg ::<%=addMsg %>
 </h1>
</fieldset>
<%}%>

<%if(deleteMsg!=null ){ %>
<fieldset>
  <h1>
  Delete msg ::<%=deleteMsg %>
 </h1>
</fieldset>
<%}%>
<%if(updateMsg!=null ){ %>
<fieldset>
  <h1>
  Update msg ::<%=updateMsg %>
 </h1>
</fieldset>
<%}%>


<%

String errorMsg = (String) request.getAttribute("errorCode");
List<Vehicle> vehicleList =(List<Vehicle>)request.getAttribute("allvehicle");

%>
<!--start container-->
<div id="sis_container">
  
    <br>
  <br>
  <fieldset>
   <%
   String oldProductNameText="";
   if(request.getAttribute("lastProductNameText")!=null){
	   oldProductNameText =(String)request.getAttribute("lastProductNameText");
   }
   %>
   
  </fieldset>
  
  
   <table width="100%" border="2" bgcolor="white">
   <tr>
    <th>id</th>
    <th>Vehicle type</th>
    <th>vehicle_name</th>
    <th>vehicle_no</th>
    <th>capacity</th>
    <th>cost</th>
    <th>action</th>
   </tr>
   
   <%
 
   for(Vehicle vehicle : vehicleList ){ %>
   <tr>
    <td><%=vehicle.getId() %></td>
    <td><%=vehicle.getVehicleType() %></td>
    <td><%=vehicle.getVehicleName() %></td>
    <td><%=vehicle.getVehicleNo()%></td>
    <td><%=vehicle.getVehicleCapacity()%></td>
    <td><%=vehicle.getVehicleCost()%></td>
    <td> <a href="vehicleupdateservlet?id=<%=vehicle.getId()%>">update</a>&nbsp;&nbsp;
      <a href="deletevehiclecontroller?id=<%=vehicle.getId()%>">delete</a>&nbsp;&nbsp;</td>
     
   
   </tr>
   <%}%>
   
   
   <% if(vehicleList.isEmpty()){ %>
   <tr>
    <td colspan="6" align="center"><h1 style="color:red;">NO RECORD FOUND</h1></td>
   </tr> 
   
   <%} %> 
  </table>
  
  
  
 
</div> 
<!--end container-->
<%@include file="footer.jsp"%> 