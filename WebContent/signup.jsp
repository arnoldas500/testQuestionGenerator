<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<style>
*{
background-color: grey;

}

</style>

<%@include file="nav.jsp" %>
<%
/*/For initial testing connection to database
Connection connection = null;
try {
	
	String driver = "com.mysql.jdbc.Driver";
	//where the databse is located
	String url = "jdbc:mysql://localhost:3306/database"; 
	String username = "arnold";
	
	Class.forName(driver);
	
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal", "root", "");
	
	if(connection != null){
		out.print("Connection established");
	}
	
} catch(Exception e) {
	out.print("connection not made");
	}
*/

%>
<!-- 
<div align="center">
<form action="SignupServlet" method="post">
User name : <input type="text" name="username" required="required">
Password : <input type="password" name="password" required="required">
Role : <input type="text" name="role" required="required">
<input type="submit" value="signup">
</form>

</div>
 -->
 <div align="center">
<form name="login" method="post" action="SignupServlet">
		<table>
			<tbody>
			
			<jsp:useBean id="jb" class="model.User"></jsp:useBean>
			
				<!-- 
			tr is for the table rows and td is for the columns
			<form>
<input type="email" pattern="[^@]*@[^@]" required oninvalid="this.setCustomValidity('Put  here custom message')"/>
<input type="submit"/>
</form>
			 -->
			 	<tr>
					<td>First Name : </td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>Last Name : </td>
					<td><input type="text" name="lastname" ></td>
				</tr>
				<tr>
					<td>User Name : </td>
					<td><input type="text" name="username" ></td>
				</tr>
				<tr>
					<td>Password : </td>
					<td><input type="password" name="password" ></td>
				</tr>


				<tr>
					<td>Roles : </td>
					<td><select name="role" required="required">
							<option value="Supplier">Supplier</option>
							<option value="Wholesaler">Wholesaler</option>
							<option value="Retailer">Retailer</option>
							<option value="Customer">Customer</option>

					</select></td>
				</tr>

				<tr>

					<td><input type="submit" value="submit"></td>
				</tr>

			</tbody>
		</table>

		<div style="color: #FF0000;">${errorMessage}</div>
	</form>
</div>

</body>
</html>