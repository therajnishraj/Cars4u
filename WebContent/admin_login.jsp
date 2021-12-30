<html>
	<head>
	    
		<title>login_form</title>
<%@include file="header.jsp"%>

<!--start container-->
<div id="sis_container">
 <center><h1>Admin_login</h1></center> 
 
 <center>
<br>
<% 

if(request.getAttribute("loginError")!=null){
	%>
    <h1 style="color:red"><%=request.getAttribute("loginError") %></h1>
<%
}//end  
%>
<br>
 <fieldset style="width:30%"><legend>Admin Login</legend>
	 <form action="adminservlet" method="post">
	   <table>
	      <tr>
	      <td>Login Id</td>
	      <td><input name="login_id" required="required" autofocus="autofocus"></td>
	      </tr>
	      
	      <tr>
		      <td>Login password</td>
	      <td><input type="password" name="login_password" required="required"></td>
	      </tr>
	      <tr>
		      <td colspan="2" align="right">
		      <input class="loginbuton" type="submit" value="Login"></td>
	      </tr>
	      
	   </table>
	 </form>
 </fieldset>
</center>
 
 
 
 
</div> 
<!--end container-->


<%@include file="footer.jsp"%>