<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>
</head>
<body>

<h2>Signup Form</h2>

<%
    String error = (String) request.getAttribute("error");
    String emailError = (String) request.getAttribute("emailError");
%>

<form action="signup" method="post">

    <label>Username:</label>
    <input type="text" name="username"
           value="<%= request.getAttribute("username") != null
                   ? request.getAttribute("username") : "" %>">
    <br><br>

    <label>Email:</label>
    <input type="text" name="email"
           value="<%= request.getAttribute("email") != null
                   ? request.getAttribute("email") : "" %>">

    <% if (emailError != null) { %>
        <p style="color:red;">
            <%= emailError %>
        </p>
    <% } %>

    <br>

    <label>Password:</label>
    <input type="password" name="password">
    <br><br>

    <% if (error != null) { %>
        <p style="color:red;">
            <%= error %>
        </p>
    <% } %>

    <input type="submit" value="Signup">

</form>

</body>
</html>