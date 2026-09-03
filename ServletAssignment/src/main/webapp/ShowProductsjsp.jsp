
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="javaBeans.product"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Product</title>
</head>

<body>

    <h2>Product Details</h2>

    <%
        product p = (product) session.getAttribute("product");
    %>

    <%
        if (p != null) {
    %>

    <table border="1" cellpadding="10">

        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Category</th>
        </tr>

        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
            <td><%= p.getCategory() %></td>
        </tr>
    </table>
    <%
        } else {
    %>
        <h3>No Product Found in Session</h3>

    <%
        }
    %>

</body>
</html>

