<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String username = (String) session.getAttribute("username");
    // Check whether user is logged in
    if (username == null) {
        response.sendRedirect("Login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post Event</title>
</head>

<body>

    <h2>Create New Event</h2>
    <p>Welcome, <%= username %></p>
    <form action="EventPostServlet" method="post">

        <label for="title">Event Title:</label>
        <br>
        <input type="text"
               id="title"
               name="title"
               required>
        <br><br>

        <label for="event_date">Event Date:</label>
        <br>
        <input type="date"
               id="event_date"
               name="event_date"
               required>
        <br><br>
        <label for="description">Description:</label>
        <br>
        <textarea id="description"
                  name="description"
                  rows="6"
                  cols="40"
                  required></textarea>
        <br><br>

        <input type="submit" value="Post Event">

    </form>

    <br>

    <a href="Home.jsp">Back to Home</a>

</body>
</html>
