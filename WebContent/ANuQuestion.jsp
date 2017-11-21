<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
 <form name="NuQuestions" method="post" action="ANuQuestionsServlet">  
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
						
					</td>

			 -->
			 <%-- <tr>
					<td>Num : <%=request.getAttribute("NqNum")%></td>
					<td><input type="text" name="NqNum"></td>
				</tr> --%>
				<h1 align="center" ><%=request.getSession().getAttribute("flag")%></h1>
<h2 align="center" style="color: #FF0000;">Please answer short answer questions:</h2>
			 
			 	<tr>
					<td>Question <%=request.getSession().getAttribute("NqNum")%>: <%=request.getSession().getAttribute("questions")%></td>
					<!-- <td><input type="text" name="questions"></td> -->
				</tr>
				
				
				
				<tr>
					<!-- <td>Answer : </td> -->
					<td>
					Answer : <input type="text" name="answer"> 
					</td>
				</tr>
				
				<tr>
					<td>Feedback : <%=request.getSession().getAttribute("feedback")%></td>
					<!-- <td><input type="text" name="feedback" ></td> -->
				</tr>
				
				<tr>
					<td>Hint 1 : <%=request.getSession().getAttribute("hint1")%></td>
					<!-- <td><input type="text" name="hint1" ></td> -->
				</tr>
				
				<tr>
					<td>Hint 2 : <%=request.getSession().getAttribute("hint2")%></td>
					<!-- <td><input type="text" name="hint2" ></td> -->
				</tr>
				
				<tr>
					<td>Hint 3 : <%=request.getSession().getAttribute("hint3")%></td>
					<!-- <td><input type="text" name="hint3" ></td> -->
				</tr>
				
				<tr>
					<td>Message : <%=request.getSession().getAttribute("message")%></td>
					<!-- <td><input type="text" name="feedback" ></td> -->
				</tr>

				<tr>
					<!-- <td>Save and Next Question</td> -->
					<td><input type="submit" name="submit" value="Submit"> 
					<input type="submit" name="next" value="Next">
					
					</td>
					<tr>
					<td>
					When you finish, click <a href="nav.jsp">here</a> to go back to the Main Page!
					</td>
					</tr>
					
					<!-- 
					<input type="submit" value="Save and Next Question" onclick="form.action='SecondServlet';">
					 -->
				</tr>

			</tbody>
		</table>

		<div style="color: #FF0000;">${errorMessage}</div>
	 </form> 
</div>

</body>
</html>