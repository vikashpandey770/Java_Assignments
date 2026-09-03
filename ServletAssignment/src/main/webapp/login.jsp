<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login Form</h2>

<%
    String error = (String) request.getAttribute("error");

    if (error != null) {
%>

    <p style="color:red; font-weight:bold;">
        <%= error %>
    </p>

<%
    }
%>

<form action="login" method="post">

    <label>Username:</label>
    <input type="text" name="username">
    <br><br>

    <label>Password:</label>
    <input type="password" name="password">
    <br><br>

    <input type="submit" value="Login">

</form>

</body>
</html>