<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MCQuestions Page</title>
</head>
<body>
<h2 align="center" style="color: #FF0000;">Please create multiple choice question:</h2>
<div align="center">
<form name="MuQuestions" method="post" action="NuQuestionsServlet">
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
					<td>Questions : </td>
					<td><input type="text" name="questions"></td>
				</tr>
				
				<tr>
					<td>Answer : </td>
					<td><input type="text" name="answer"></td>
				</tr>
				<tr>
					<td>Hint 1 : </td>
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
					<td><input type="submit" value="submit"> <a href="nav.jsp">I am done!</a> </td>
				</tr>

			</tbody>
		</table>

		<div style="color: #FF0000;">${errorMessage}</div>
	</form>
</div>


</body>
</html>