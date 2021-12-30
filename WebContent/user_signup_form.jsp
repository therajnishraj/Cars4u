<html>
	<head>
	    
		<title>UserSignUpForm</title>
<%@include file="header.jsp"%>

 <!-- *************************** Start Container *************************** -->

 <fieldset id="otpform"><legend>verfiy email </legend>
 <%
 String userEmail= "";
 if(session.getAttribute("userEmail")!=null){
	 userEmail  =(String) session.getAttribute("userEmail");
 }
 %>
 <form action="signupdb" method="post">
  <table>
  	<tr>
	 <td>Email</td>
	 <td><input name="user_email" readonly="readonly"  type="email"  value="<%=userEmail%>"  style="color:red;"></td>
	</tr>
	<tr>
		 <td>Name</td>
		 <td><input name="user_name"    required="required"></td> 
	 </tr>
	
	 <tr>
		 <td>MobileNo</td>
		 <td><input name="user_mobile"    required="required"></td> 
	 </tr>
	 <tr>
	 <td>Password</td>
	 <td><input type="password" name="user_password"     required="required"></td>
	 </tr>
	 <tr>
	 <td colspan="4" align="right"><input type="submit" value="Sign-Up" ></td>
 	 </tr>
  </table>
</form>
 </fieldset>
 <!-- ***************************End Container *************************** -->

<%@include file="footer.jsp"%>