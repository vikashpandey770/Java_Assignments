<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String username = (String) session.getAttribute("username");

    if (username == null) {
        response.sendRedirect("Loginpart.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>

    <h1>Welcome, <%= username %>!</h1>

    <p>You have successfully logged in.</p>

    <a href="LogoutServlet">Logout</a>

</body>
</html>
