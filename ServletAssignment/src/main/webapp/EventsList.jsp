
<%@page import="javaBeans.Event"%>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<%
    List<Event> events =
        (List<Event>) request.getAttribute("events");
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>All Events</title>
</head>

<body>

<h2>All Events</h2>

<%
    if (events != null && !events.isEmpty()) {

        for (Event event : events) {
%>

    <div style="border:1px solid black;
                padding:15px;
                margin:10px;
                width:500px;">

        <h3><%= event.getTitle() %></h3>

        <p>
            <strong>Date:</strong>
            <%= event.getEventDate() %>
        </p>

        <p>
            <strong>Posted By:</strong>
            <%= event.getUsername() %>
        </p>

        <p>
            <strong>Description:</strong>
            <%= event.getDescription() %>
        </p>

    </div>

<%
        }

    } else {
%>

    <p>No events available.</p>

<%
    }
%>

<br>

<a href="Home.jsp">Back to Home</a>

</body>
</html>
