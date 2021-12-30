<html>
	<head>
	    
		<title>Registration</title>

<%@include file="header.jsp"%>
<!-- ++++++++++++++++++++++++++++ container +++++++++++++++++++++++++++++++++++++++ -->
<!--start container-->
<div id="sis_container">
   <center><h1>Verify your Email</h1></center> 
   <center>
        <fieldset style="width: 30%; height: 15%;"> <legend><strong>Verfiy email</strong> </legend> 
           
            <form action="emailvalidate" method="post">
            
            Email<input name="user_email"  type="email" required="required">
            <input class="loginbuton" type="submit" value="verify email" >
           </form>
            </fieldset>
    </center>
 
</div> 
<!--end container-->


<%@include file="footer.jsp"%>