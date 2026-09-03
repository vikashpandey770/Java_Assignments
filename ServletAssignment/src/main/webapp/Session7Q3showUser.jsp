<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
String username=request.getParameter("username");

%>

<h2>Welcome, <%=username %>!</h2>
<p>current time; </p>
<%=LocalDate.now() %>

</body>
</html>