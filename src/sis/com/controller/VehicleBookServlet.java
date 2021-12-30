package sis.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sis.com.bo.Vehicle;

/**
 * Servlet implementation class VehicleBookServlet
 */
public class VehicleBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder errorCode = new StringBuilder();
		//String updateMessge="";
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
		request.getRequestDispatcher("book_form.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt  =null;
		StringBuilder errorCode=new StringBuilder("");

		//declare required type 
		String dbuser="system";
		String dbpassword="root";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
		String message="";
		

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,dbuser,dbpassword);
/*	insert into sis_product(id,name,price,details,dom) 
			values(sis_product_seq.nextval,?,?,?,?);
*/
			String sql="insert into orderCarInfo values(?,?,?,?,?,?,?,?,0)";

			pstmt  = con.prepareStatement(sql);
			//set 
			pstmt.setInt(1,Integer.parseInt(request.getParameter("id")));
			pstmt.setString(2,request.getParameter("vehicle_name"));
			pstmt.setString(3,request.getParameter("vehicle_no"));
			pstmt.setString(4,request.getParameter("cost"));
			pstmt.setString(5,request.getParameter("name"));
			pstmt.setString(6,request.getParameter("mobile"));
			pstmt.setString(7,request.getParameter("bookFrom"));
			pstmt.setString(8,request.getParameter("bookTo"));


			int result  = pstmt.executeUpdate();
		   if(result ==1){
			  message="booking request sent"; 
			}else{
				message="something went wrong ..fill information properly";
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
		request.setAttribute("errorCode",errorCode.toString());
		request.setAttribute("message", message);
		request.getRequestDispatcher("viewRequestUserServlet").forward(request, response);

	}

}
