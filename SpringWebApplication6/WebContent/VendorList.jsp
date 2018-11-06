<%@page import="com.tadigital.entity.Vendor"%>
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

<% ArrayList<Vendor>list=(ArrayList<Vendor>)session.getAttribute("VENDORLIST"); 
  for(Vendor vendor:list){ 
  %>
  <table border="1px">
  <tr> 
  <td><%=vendor.getName() %></td> 
  <td><%=vendor.getEmail() %></td>
  <td><a href ="delete<%= vendor.getId() %>">DELETE</a></td>
  </tr> 
 <%} %> 
 </table>


</body>
</html>