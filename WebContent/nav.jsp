<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	<form name="nav">

<style>
* {
padding: 0;
margin: 0;
}


nav {
background-color: black;
height: 50px;
}

nav ul{
height: 50px;
width : 907px;
margin: 0 auto;
}

nav ul li {
list-style-type: none;
width: 150px;
float: left;
border-right: 1px solid #CCC;
text-align: center;
}

nav ul li a{
text-decoration:none;
color: white;
line-height: 50px;
display: block;

}

li a:hover {
background-color: yellow;
color: red;
}

</style>

		<nav>
		<ul class="tab-group">
			<li><a href="Student.jsp">Student</a></li>
			<li><a href="TA.jsp">TA</a></li>
			
			<li><a href="Instructor.jsp">Instructor</a></li>
			<li><a href="Login.jsp">Login</a></li>
			<li><a href="signup.jsp">Signup</a></li>
		</ul>
		</nav>
<!-- 
		ul { list-style-type: none; margin: 0; padding: 0; overflow: hidden;
		background-color: #333; } li { float: left; } li a { display: block;
		color: white; text-align: center; padding: 14px 16px; text-decoration:
		none; } /* Change the link color to #111 (black) on hover */ li
		a:hover { background-color: #111; }
 -->
		<%
		//String redirectURL = "http://whatever.com/myJSPFile.jsp";
		//response.sendRedirect(redirectURL);
	%>

	</form>
</body>
</html>