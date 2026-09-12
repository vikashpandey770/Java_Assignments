<%@page import="com.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<style type="text/css">
tr,td{
padding: 10px;
}

</style>

<body>

<% 

 Product p=(Product)request.getAttribute("p");
%>

<form name="insert" method="post" action="ProductController">

<table>
<tr>
<td><input type="hidden" name="id" value="<%=p.getId() %>"></td>


</tr>


<tr>
<td>  name</td>
<td><input type="text" name="name" value="<%=p.getName()%>">
</tr>


<tr>
<td>  Brand</td>
<td><input type="text" name="brand" value="<%=p.getBrand()%>">
</tr>

<tr>
<td> Price</td>
<td><input type="text" name="price" value="<%=p.getPrice() %>"  > 
</tr>

<tr>
<td colspan="2" align ="center">
<input type="submit" name="action" value="update">
  </td>
</tr>




</table>

<a href="insertpages.jsp">
INSERT EMP DATA
</a>

</form>

</body>
</html>