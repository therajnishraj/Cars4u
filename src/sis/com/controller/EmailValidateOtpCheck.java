package sis.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EmailValidateOtpCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		
		String userEmail  =(String) session.getAttribute("userEmail");

		System.out.println("step3"+userEmail);
		//String userEmail  = request.getParameter("user_email");

		String userInputotp  = request.getParameter("user_otp");
		String createdOtp=""; 
		       if(session.getAttribute("otp")!=null){
		    	   createdOtp =(String) session.getAttribute("otp");
		       }

		if(createdOtp.equals(userInputotp)){
			
			session.setAttribute("userEmail", userEmail);
			//request.getRequestDispatcher("signupdb").forward(request, response);
			response.sendRedirect("signupdb");
			//request.getRequestDispatcher("user_signup_form.jsp").forward(request, response);
			
		}else{
			request.setAttribute("otpError", "Otp not matched");
			session.setAttribute("userEmail", userEmail);
			request.getRequestDispatcher("otp_form.jsp").forward(request, response);

		}


	}

}
