<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="nav.jsp" %>
</head>
<body>
<body>
	<h1>Retailer Information</h1>
	Hello, you logged in successfully
	<center></center>
	<div style="color: #FF0000;">
		Welcome, Retailer

		<%= request.getSession().getAttribute("currentUser") %>
		! Current time is :
		<%
         Date date = new Date();
         //out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
         out.print( date.toString());
      %>
	<%@include file="logout.jsp" %>
	</div>
</body>
</html>