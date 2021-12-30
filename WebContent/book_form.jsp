
<%@page import="sis.com.bo.Vehicle" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%
  //System.out.println("hello")	; 
  Vehicle product  = null;
  if(request.getAttribute("product")!=null){
   product  = (Vehicle)request.getAttribute("product");
  }
  %>
  <center>
<br>
<br>
 <fieldset style="width:60%"><legend>update Product</legend>
	 <form action="vehiclebookservlet" method="post">
	   <table>
	   <tr>
	      <td>car_id</td>
	      <td><input  value="<%=product.getId() %>"  name="id" readonly="readonly" style="background-color: gray;"></td>
	      </tr>
	      
		  <tr>
	      <td>Vehicle_Name</td>
	      <td><input  value="<%=product.getVehicleName() %>"  name="vehicle_name" required="required"></td>
	      </tr>
	      
	      <tr>
	      <td>Vehicle_No</td>
	      <td><input  value="<%=product.getVehicleNo() %>"  name="vehicle_no" required="required"></td>
	      </tr>
	      
	      
	      <tr>
	      <td>Cost</td>
	      <td><input  value="<%=product.getVehicleCost() %>"  name="cost" required="required"></td>
	      </tr>
	      
	       <tr>
	      <td>Customer_Name</td>
	      <td><input  value=""  name="name" required="required"></td>
	      </tr>
		 
		  <tr>
	      <td>Customer_Mob</td>
	      <td><input  value=""  name="mobile" required="required"></td>
	      </tr>
	      
	       <tr>
	      <td>Booking_from</td>
	      <td><input type="date"  value=""  name="bookFrom" required="required"></td>
	      </tr>
	      
	       <tr>
	      <td>Booking_to</td>
	      <td><input type="date" value=""  name="bookTo" required="required"></td>
	      </tr>
		 
	       <tr>
		      <td colspan="2" align="right">
		      <input type="submit" value="book vehicle"></td>
	      </tr>
	      
	   </table>
	 </form>
 </fieldset>
</center>
  



</body>
</html>