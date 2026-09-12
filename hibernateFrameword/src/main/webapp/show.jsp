<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.Product"%>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Product List</title>


<style>
table {
    border-collapse: collapse;
    width: 80%;
}
th, td {
    border: 1px solid black;
    padding: 10px;
    text-align: center;
}
th {
    background-color: lightgray;
}
</style>
</head>
<body>
<table>

<tr>
    <th>id</th>
    <th>NAME</th>
    <th>Brand</th>
    <th>Price</th>
    <th>EDIT</th>
    <th>DELETE</th>
</tr>

<%
    List<Product> list = ProductDao.getAllPro();
    for(Product p : list) {
%>
<tr>

    <td><%=p.getId()%></td>
    <td><%=p.getName()%></td>
    <td><%=p.getBrand()%></td>
    <td><%=p.getPrice()%></td>
    
	<td>
	<form name="edit" method="post" action="ProductController">
	<input type="hidden" name="id" value="<%=p.getId() %>">
	<input type="submit" name="action" value="EDIT"class ="btn btn-primary">
	</form>
	</td>


	<td>
	<form name="delete" method="post" action="ProductController">
	<input type="hidden" name="id" value="<%=p.getId() %>">
	<input type="submit" name="action" value="Delete"class ="btn btn-danger">
	</form>
	</td>
</tr>
<%
    }
%>
</table>

<a href="insert.jsp">Insert new Student</a>
</body>
</html>