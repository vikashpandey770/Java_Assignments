<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Restaurant</title>
</head>
<body>
    <h2>Add New Restaurant</h2>
    <form action="AddRestaurantServlet" method="post">
        Restaurant Name: <input type="text" name="name" required><br><br>
        Cuisine Type: <input type="text" name="cuisine" required><br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>