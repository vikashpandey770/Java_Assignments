<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String username = (String) session.getAttribute("username");
%>

    <h2>Welcome, <%= username %>!</h2>
    
     <form action="LogoutServlet"method="post">
       <button type="submit">Logout</button>
    	</form>

</body>
</html>