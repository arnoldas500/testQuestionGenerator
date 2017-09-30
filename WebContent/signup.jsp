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

<%
Connection connection = null;
try {
	/*
	String driver = "com.mysql.jdbc.Driver";
	//where the databse is located
	String url = "jdbc:mysql://localhost:3306/database"; 
	String username = "arnold";
	String password = "422981a1";
	Class.forName(driver);
	*/
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
	
	if(connection != null){
		out.print("Connection established");
	}
	
} catch(Exception e) {
	out.print("connection not made");
	}

/*

<div align="center">
<form action="SignupServlet" method="post">
User name : <input type="text" name="user" required="required">
Password : <input type="password" name="password" required="required">
<input type="submit" value="signup">
</form>

</div>

*/

%>




</body>
</html>