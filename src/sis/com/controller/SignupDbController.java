package sis.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;





import sis.com.bo.User;
/**
 * Servlet implementation class SignupDbController
 */
public class SignupDbController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher rd= request.getRequestDispatcher("user_signup_form.jsp");
		//rd.forward(request, response);
	request.getRequestDispatcher("user_signup_form.jsp").forward(request, response);;
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder errorCode = new StringBuilder();
		String  email= request.getParameter("user_email");
		String  name= request.getParameter("user_name");
		String  mobile= request.getParameter("user_mobile");
		String  password= request.getParameter("user_password");

		System.out.println(email);
		System.out.println(name);
		System.out.println(mobile);
		System.out.println(password);
		
		String addMsg="";
		
		Connection con = null;
		PreparedStatement pstmt  =null;

		//declare required type 
		String dbuser="system";
		String dbpassword="root";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";	

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,dbuser,dbpassword);
/*	insert into sis_product(id,name,price,details,dom) 
			values(sis_product_seq.nextval,?,?,?,?);
*/
			String sql="insert into signup_user(id,email,name,mobile,password)"
					+ " values(signup_user_seq.nextval,?,?,?,?)" ; 
			pstmt  = con.prepareStatement(sql);
			//set 
			pstmt.setString(1,email);
			pstmt.setString(2,name);
			pstmt.setString(3,mobile);
			pstmt.setString(4,password);

			int result  = pstmt.executeUpdate();
		   if(result ==1){
			   addMsg = " Record  Added Successfuly ";
			}else{
			   addMsg = " Record  Not Added ";
			}


		}catch(ClassNotFoundException e){
		  errorCode.append("<h1 style='color:red'>Driver Not Loaded....." + e.getMessage()+"</h1>");
		}catch(SQLException e){
		  errorCode.append("<h1 style='color:red'>DB ERROR : " +e.getMessage()+"</h1>");
		  e.printStackTrace();
		}catch(Exception e){
		  errorCode.append("<h1 style='color:red'>Other ERROR " + e.getMessage()+"</h1>");
		}finally{
		    //release resoucer
		     if(con!=null){
			          try{
					     con.close();  //#5 close connection 
						}catch(SQLException e){
							 errorCode.append("DB Con CLosing ERROR : "+ e.getMessage());
					  }//catch
			  }//if
		}//finally

		//jdbc done
		
		//in redirect request attribute NOT WORK
		
				//session set  or query string(param) 
				//response.sendRedirect("showallproduct");
				//send msg with query string as request parameter
			response.sendRedirect("login");
				//redirect show all product page
				//way2
				//or you can create one page which showm add mesg 
				//add_msg.jsp  and forward with attribue 
		
		System.out.println(addMsg);
	}

}
