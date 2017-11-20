<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Please choose questions to answer</h1>
<form action="AnswerQuestions" method="post" > 


<input type="submit" name="action" value="AMCQuestionsServlet">
    <input type="submit" name="action" value="ANuQuestionsServlet">
<!-- 
<a href="AMCQuestions.jsp">Multiple-Choice Questions</a>
<input type="submit" value="Multiple-Choice Questions"> 
<input type="submit" value="Numeric Questions"> 
<a href="ANuQuestion.jsp">Numeric Questions</a>
 -->
</form>
</body>
</html>