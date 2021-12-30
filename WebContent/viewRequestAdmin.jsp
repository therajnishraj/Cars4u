<%@page import="sis.com.bo.OrderInfo" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table border='1' width='100%'>
<tr>
<th>id</th>
<th>vechileName</th>
<th>vechileNo </th>
<th>cost </th>
<th>customerName </th>
<th>customerMob </th>
<th>bookFrom </th>
<th>bookTo </th>
<th>orderStatus</th>
</tr>
<%
ArrayList<OrderInfo> orderList=(ArrayList<OrderInfo>) request.getAttribute("orderList");

for(OrderInfo order:orderList){
%>
<tr>

<td><%=order.getId() %></td>
<td><%=order.getVechileName()%></td>
<td><%=order.getVechileNo() %></td>
<td><%=order.getCost() %></td>
<td><%=order.getCustomerName() %></td>
<td><%=order.getCustomerMob() %></td>
<td><%=order.getBookFrom() %></td>
<td><%=order.getBookTo()%></td>
<%if(order.getOrderStatus()==0) {%>
     <td> <a href="viewRequestAdmin2?id=<%=order.getId() %>" >Approval YES</a></td>
	<%}else{ %>
	<td>Approved<td>
	<%} %>
	
</tr>
<%} %>

</table>
	</form>

</body>
</html>