package sis.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sis.com.bo.OrderInfo;

/**
 * Servlet implementation class ViewRequestAdminServlet
 */
public class ViewRequestAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequestAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<OrderInfo> orderList=new ArrayList<OrderInfo>();
		StringBuilder errorCode=new StringBuilder("");
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
			String sql="select * from orderCarInfo" ; 
			pstmt  = con.prepareStatement(sql);
			
			//******************************************
			rs  =  pstmt.executeQuery();
			while( rs.next() ){
		          int id  =rs.getInt("id");
				  String vehicleName  = rs.getString("vechileName");
				  String vehicleNo  =rs.getString("vechileNo");
				  String customerName  =rs.getString("customerName");
				  String customerMobile  =rs.getString("customerMob");
				  Float cost  =rs.getFloat("cost");
				  Date bookfrom=rs.getDate("bookFrom");
				  Date bookto=rs.getDate("bookTo");
				  int orderStatus=rs.getInt("orderStatus");

				  
				  OrderInfo order=new OrderInfo();
				  order.setId(id);
				  order.setVechileName(vehicleName);
				  order.setVechileNo(vehicleNo);
				  order.setBookFrom(bookfrom);
				  order.setBookTo(bookto);
				  order.setCustomerName(customerName);
				  order.setCustomerMob(customerMobile);
				  order.setCost(cost);	
				  order.setOrderStatus(orderStatus);
				  orderList.add(order);
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
	request.setAttribute("orderList", orderList);
request.getRequestDispatcher("viewRequestAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderInfo o=new OrderInfo();
		o=(OrderInfo)request.getAttribute("order");
		response.getWriter().print(o.getId()+"order approved");
	}

}
