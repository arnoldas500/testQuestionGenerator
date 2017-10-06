<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="nav.jsp"%>
</head>
<body>
<style>
*{
background-color: grey;

}

</style>
	<h1>Supplier Information</h1>
	Hello, you logged in successfully
	<center></center>
	<div style="color: #FF0000;">
		Welcome, Supplier

		<%=request.getSession().getAttribute("currentUser")%>
		! Current time is :
		<%
		Date date = new Date();
		//out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
		out.print(date.toString());

		/*
		out.println("<form action=\"logout.jsp\" method=\"post\">");
		out.println("<input type=\"submit\" name=\"logout\" value=\"Logout\">");
		out.println("</form>");
		*/
	%>



	</div>
	<div>
		<h2>User info:</h2>
		<table>
			<tbody>
				<tr>
					<td>Username : <%=request.getSession().getAttribute("currentUser")%>
						; Role : <%=request.getSession().getAttribute("roles")%>
					</td>
				</tr>
				<tr>
					<td>First Name : <%=request.getSession().getAttribute("firstName")%>
						; Last Name : <%=request.getSession().getAttribute("lastName")%>
					</td>
				</tr>

			</tbody>
		</table>


		<%@include file="logout.jsp"%>
	</div>
</body>
</html>