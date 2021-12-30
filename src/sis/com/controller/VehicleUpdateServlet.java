package sis.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import sis.com.bo.Vehicle;

/**
 * Servlet implementation class VehicleUpdateServlet
 */
public class VehicleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    System.out.println("doGet")	;
		StringBuilder errorCode = new StringBuilder();
		String updateMessge="";
		String  productIdStr= request.getParameter("id");

		long productId  = Long.parseLong(productIdStr);
		
		//id base 
		//db fetch record
		//create pojo  product obj
		//send to view 
		Vehicle product = null;
		  //jdbc   db logic
			Connection con = null;
			PreparedStatement pstmt  =null;
			ResultSet rs =null;
			//declare required type 
			String user="system";
			String password="root";
			String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con  = DriverManager.getConnection(url,user,password);
				String sql="select * from vehicle where id=?" ; 
				pstmt  = con.prepareStatement(sql);
				pstmt.setLong(1,productId);
				//******************************************
				rs  =  pstmt.executeQuery();
				if( rs.next() ){
			          long id  =rs.getLong("id");
					  String vehicleType  = rs.getString("vehicle_type");
					  String vehicleName  = rs.getString("vehicle_name");
					  String vehicleNo  =rs.getString("vehicle_no");
					  int capacity  =rs.getInt("capacity");
					  Float cost  =rs.getFloat("cost");
					  
					  
					  product  = new Vehicle();
					  product.setId(id);
					  product.setVehicleType(vehicleType);
					  product.setVehicleName(vehicleName);
					  product.setVehicleNo(vehicleNo);
					  product.setVehicleCapacity(capacity);
					  product.setVehicleCost(cost);
					   
				}//end if
				
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
		request.setAttribute("errorCode", errorCode.toString());
		request.setAttribute("product",product);
		request.getRequestDispatcher("updateAdminvehicle.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("doPost")	;
StringBuilder errorCode = new StringBuilder();
		
		int  id= Integer.parseInt(request.getParameter("id"));
		
		String  vehicleType= request.getParameter("vehicle_type");
		String  vehicleName= request.getParameter("vehicle_name");
		String  vehicleNo = request.getParameter("vehicle_no");
		int  capacity = Integer.parseInt(request.getParameter("Capacity"));
		Float  cost = Float.parseFloat(request.getParameter("cost"));
        
         
		System.out.println(id);
		System.out.println(vehicleType);
		System.out.println( vehicleName);
		System.out.println(vehicleNo);
		System.out.println(capacity);
		System.out.println(cost);
	
		//IF ERROR send udpate 
		if(errorCode.length()>0){
			request.setAttribute("errorCode", errorCode.toString());
			request.getRequestDispatcher("updateAdminvehicle.jsp").forward(request, response);
			return;
		}
		
		
		
		
		String updateMessage="";
		//db insert
		
		Connection con = null;
		PreparedStatement pstmt  =null;

		//declare required type 
		String dbuser="system";
		String dbpassword="root";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";	

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,dbuser,dbpassword);
 
			String sql="update  vehicle set vehicle_type=?,vehicle_name=?,vehicle_no=?,capacity=?,cost=? where id=?"; 
			pstmt  = con.prepareStatement(sql);
			//set 
			pstmt.setString(1,vehicleType);
			pstmt.setString(2,vehicleName);
			pstmt.setString(3,vehicleNo);
			pstmt.setInt(4,capacity);
			pstmt.setFloat(5, cost);
			pstmt.setInt(6, id);

			int result  = pstmt.executeUpdate();
		   if(result ==1){
			   updateMessage = " Record  udpated Successfuly ";
			}else{
			   updateMessage = " Record  Not updated ";
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
	//	response.sendRedirect("viewvehicleadmin");
		response.sendRedirect("viewvehicleadmin?update_msg="+updateMessage);

	}

}
