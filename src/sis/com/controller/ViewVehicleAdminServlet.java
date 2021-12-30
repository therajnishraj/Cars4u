package sis.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sis.com.bo.Vehicle;

/**
 * Servlet implementation class ViewVehicleServlet
 */
public class ViewVehicleAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 List<Vehicle> vehicleList  = new ArrayList<Vehicle>();
			
		    StringBuilder errorCode = new StringBuilder();
			  //jdbc   db logic
				Connection con = null;
				Statement stmt  =null;
				ResultSet rs =null;
				//declare required type 
				String user="system";
				String password="root";
				String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
			try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con  = DriverManager.getConnection(url,user,password);
					stmt  = con.createStatement();
					//******************************************
					String sql="select * from vehicle order by id desc" ; 
					rs  =  stmt.executeQuery(sql);
					while( rs.next() ){
				          long id  =rs.getLong("id");
						  String vehicleType  = rs.getString("vehicle_type");
						  String vehicleName  = rs.getString("vehicle_name");
						  String vehicleNo  = rs.getString("vehicle_no");
						  int capacity  = rs.getInt("capacity");
						  float cost  = rs.getFloat("cost");
						 
						  
						  Vehicle veh  = new Vehicle();
						  veh.setId(id);
						  veh.setVehicleType(vehicleType);
						  veh.setVehicleName(vehicleName);
						  veh.setVehicleNo(vehicleNo);
						  veh.setVehicleCapacity(capacity);
						  veh.setVehicleCost(cost);
					 
						  vehicleList.add(veh);
					}//end while 
					
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
			//add attribute for presentation /view
			request.setAttribute("errorCode",errorCode.toString());
			request.setAttribute("allvehicle", vehicleList);
			request.getRequestDispatcher("ViewVehicleAdmin.jsp").forward(request, response);
			
		}

	
	}

	
	
	

