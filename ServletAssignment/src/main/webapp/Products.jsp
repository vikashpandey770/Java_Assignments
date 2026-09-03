<%@page import="javaBeans.productdata"%>
<%@ page import="java.util.List" %>
<%@ page import="javaBeans.productdata" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

    <title>Product List</title>

    <style>

        body {
            font-family: Arial;
            background-color: #f2f2f2;
        }

        h2 {
            text-align: center;
        }

        table {
            width: 60%;
            margin: auto;
            border-collapse: collapse;
            background-color: white;
        }

        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #333;
            color: white;
        }

    </style>

</head>

<body>

<h2>Product List</h2>

<%
    List<productdata> products =
            (List<productdata>) request.getAttribute("products");
%>

<table>

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>

<%
    if (products != null && !products.isEmpty()) {

        for (productdata product : products) {
%>

    <tr>

        <td>
            <%= product.getId() %>
        </td>

        <td>
            <%= product.getName() %>
        </td>

        <td>
            ₹<%= product.getPrice() %>
        </td>

    </tr>
    
    <form action="products" method="get">

    <input type="text" name="name"
           placeholder="Search product">

    <input type="submit" value="Search">

</form>
    

<%
        }

    } else {
%>

    <tr>
        <td colspan="3">
            No products found.
        </td>
    </tr>

<%
    }
%>

<%
    String error = (String) request.getAttribute("error");

    if (error != null) {
%>

    <p style="color:red;">
        <%= error %>
    </p>

<%
    }
%>

</table>

</body>
</html>