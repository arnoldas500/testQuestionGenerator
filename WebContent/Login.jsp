<!-- 
comand shit f to format everything after selecting
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<!-- 
	the login form //the action is where you want to go when someone
	clicks submits //logincheck is a servlet which i create so when you
	click login //you go from the jsp to the servlet
	 -->
	<form name="login" method="post" action="LoginServlet">
		<table>
			<tbody>
				<!-- 
			tr is for the table rows and td is for the columns
			 -->
				<tr>
					<td>User Name</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>


				<tr>
					<td>Roles:</td>
					<td><select name="roles">
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

		<input type="reset" value="Clear" name="clear" />

		<div style="color: #FF0000;">${errorMessage}</div>
		<!-- <c:remove var="errorMessage" scope="session" />  -->
	</form>
</body>
</html>