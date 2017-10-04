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
/*
out.println("<form action=\"logout.jsp\" method=\"post\">");
out.println("<input type=\"submit\" name=\"logout\" value=\"Logout\">");
out.println("</form>");
*/

//destroyung session with invalidate method and then creating a frsh new session with no username attribute
session.invalidate();
session = request.getSession();
response.sendRedirect("Login.jsp");

%>

</body>
</html>