<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<td>Username : <%=request.getSession().getAttribute("choiceA")%>
						; Role : <%=request.getSession().getAttribute("roles")%>
					</td>
					<div style="color: #FF0000;">${choiceA}</div>

<h2 align="center" style="color: #FF0000;">Please answer multiple choice question:</h2>
<div align="center">
 <form name="MCQuestions" method="post" action="AMCQuestionsServlet">  
		<table>
			<tbody>
			
			<jsp:useBean id="jb" class="model.User"></jsp:useBean>
			
				<!-- 
			tr is for the table rows and td is for the columns
			<form>
<input type="email" pattern="[^@]*@[^@]" required oninvalid="this.setCustomValidity('Put  here custom message')"/>
<input type="submit"/>
</form>

<td>Username : <%=request.getSession().getAttribute("currentUser")%>
						; Role : <%=request.getSession().getAttribute("roles")%>
					</td>

			 -->
			 <td>Username : <%=request.getSession().getAttribute("questions")%>
						; Role : <%=request.getSession().getAttribute("roles")%>
						<%=request.getAttribute("questions")%>
					</td>
			 	<tr>
					<td>Questions : <%=request.getSession().getAttribute("questions")%></td>
					<td><input type="text" name="questions"></td>
				</tr>
				<tr>
					<td>Choice A : <%=request.getSession().getAttribute("choiceA")%></td>
					<td><input type="text" name="choiceA" ></td>
				</tr>
				<tr>
					<td>Choice B : <%=request.getSession().getAttribute("choiceB")%></td>
					<td><input type="text" name="choiceB" ></td>
				</tr>
				<tr>
					<td>Choice C : <%=request.getSession().getAttribute("choiceC")%></td>
					<td><input type="text" name="choiceC" ></td>
				</tr>
				<tr>
					<td>Choice D : <%=request.getSession().getAttribute("choiceD")%></td>
					<td><input type="text" name="choiceD" ></td>
				</tr>
				
				
				<tr>
					<td>Answer : </td>
					<td><select name="answer" required="required">
							<option value="a">A</option>
							<option value="b">B</option>
							
							<option value="c">C</option>
							<option value="d">D</option>

					</select></td>
				</tr>
				<tr>
					<td>Hint 1 : <%=request.getSession().getAttribute("hint1")%></td>
					<td><input type="text" name="hint1" ></td>
				</tr>
				
				<tr>
					<td>Hint 2 : </td>
					<td><input type="text" name="hint2" ></td>
				</tr>
				
				<tr>
					<td>Hint 3 : </td>
					<td><input type="text" name="hint3" ></td>
				</tr>
				
				<tr>
					<td>Feedback : </td>
					<td><input type="text" name="feedback" ></td>
				</tr>

				<tr>
					<td>Save and Next Question</td>
					<td><input type="submit" value="Save and Next Question"> <a href="nav.jsp">I am done!</a> </td>
				</tr>

			</tbody>
		</table>

		<div style="color: #FF0000;">${errorMessage}</div>
	 </form> 
</div>



</body>
</html>