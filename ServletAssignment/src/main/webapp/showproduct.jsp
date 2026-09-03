<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="javaBeans.product" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>All Products</title>
</head>

<body>

<h2>Registered Products</h2>

<%
    List<product> products =
        (List<product>) session.getAttribute("products");
%>


<%
    if (products != null && !products.isEmpty()) {
%>

<table border="1" cellpadding="10">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Category</th>
    </tr>


    <%
        for (product p : products) {
    %>

    <tr>

        <td>
            <%= p.getId() %>
        </td>

        <td>
            <%= p.getName() %>
        </td>

        <td>
            <%= p.getPrice() %>
        </td>

        <td>
            <%= p.getCategory() %>
        </td>

    </tr>

    <%
        }
    %>

</table>

<%
    } else {
%>

<h3>No Products Registered</h3>

<%
    }
%>


<br>

<a href="addProduct.jsp">Add Another Product</a>

</body>

</html>