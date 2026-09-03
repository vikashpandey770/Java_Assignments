<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String username = (String) session.getAttribute("username");

    // Agar session expire ho gaya hai ya logout ho gaya hai
    if (username == null) {
        response.sendRedirect("login.html");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>

    <h1>Welcome, <%= username %>!</h1>

    <p>You are logged in.</p>

    <form action="LogoutServlet" method="post">
        <button type="submit">Logout</button>
    </form>

</body>
</html>