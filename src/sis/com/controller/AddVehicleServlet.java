package sis.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddVehicleServlet
 */
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add_vehicle.jsp").forward(request, response);;

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		StringBuilder errorCode = new StringBuilder();
		String  vehicleType= request.getParameter("vehicle_type");
		String  vehicleName= request.getParameter("vehicle_name");
		String  vehicleNo= request.getParameter("vehicle_no");
		String  vehicleCapacity= request.getParameter("vehicle_capacity");
		String  vehicleCost= request.getParameter("vehicle_cost");

		System.out.println(vehicleType);
		System.out.println(vehicleName);
		System.out.println(vehicleNo);
		System.out.println(vehicleCapacity);
		System.out.println(vehicleCost);
		
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
			String sql="insert into vehicle(id,vehicle_type,vehicle_name,vehicle_no,capacity,cost)"
					+ " values(vehicle_seq.nextval,?,?,?,?,?)" ; 
			pstmt  = con.prepareStatement(sql);
			//set 
			pstmt.setString(1,vehicleType);
			pstmt.setString(2,vehicleName);
			pstmt.setString(3,vehicleNo);
			pstmt.setString(4,vehicleCapacity);
			pstmt.setString(5,vehicleCost);

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
	    response.sendRedirect("viewvehicle?add_msg"+addMsg);
				//redirect show all product page
				//way2
				//or you can create one page which showm add mesg 
				//add_msg.jsp  and forward with attribue 
		
		System.out.println(addMsg);
		//response.getWriter().print(addMsg);
		
		//request.setAttribute("addMsg", "Success");
		//request.getRequestDispatcher("add_vehicle.jsp").forward(request, response);
	}

}
