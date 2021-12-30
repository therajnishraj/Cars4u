<html>
	<head>
	    
		<title>otp_form</title>

<%@include file="header.jsp"%>

<!-- +++++++++++++++++++++++++ container ++++++++++++++++++++++++++
 -->
<!--start container-->
<div id="sis_container">
 <center><h1>Verify OTP</h1></center> 
 
 <center>

<fieldset style="width: 30%; height: 15%;"><legend> <strong> verfiy email </strong></legend>
   <%
    String userEmail= "";
    if(session.getAttribute("userEmail")!=null){
        userEmail  =(String) session.getAttribute("userEmail");
    }
    
    
    System.out.println("step2 :: "+userEmail);
    %>
    <%if(request.getAttribute("otpError")!=null){ %>
       <h1 style="color:red;"><%= request.getAttribute("otpError")%></h1> 
    <%} %>   
    <!-- <form action="emailvalidate_otp_check.jsp" method="post"> -->
      <form action="emailvalidateotpcheck" method="post"> 
     
    Email<input name="user_email" readonly="readonly"  type="email"  value="<%=userEmail%>" required="required"><br> 
    OTP<input name="user_otp" value=""  required="required"><br> 
    
    <input class="loginbuton" type="submit" value="check OTP" >
   </form>
    </fieldset>

</center>
 
 
 
 
</div> 
<!--end container-->


<%@include file="footer.jsp"%>