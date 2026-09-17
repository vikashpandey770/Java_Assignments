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
<form name="insert" method="post" action="MyController">
<table>
<tr>
<td> first name</td>
<td><input type="text" name="fname"></td>
</tr>
<tr>
<td> last name</td>
<td><input type="text" name="lname"></td>
</tr>
<tr>
<td>email</td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td><input type="submit" name="action" value="insert"></td>
</tr>

</table>
</form>
</body>
</html>