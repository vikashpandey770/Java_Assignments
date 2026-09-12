
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

<form name="insert" method="post" action="ProductController">

<table>

<tr>
<td> Product name</td>
<td><input type="text" name="fname">
</tr>

<tr>
<td> Product brand</td>
<td><input type="text" name="brand">
</tr>


<tr>
<td>  price</td>
<td><input type="text" name="price">
</tr>


<tr>
<td colspan="2" align ="center">
<input type="submit" name="action" value="insert">
 
  </td>
</tr>

</table>
</form>

<a href="show.jsp">Show</a>
</body>
</html>
