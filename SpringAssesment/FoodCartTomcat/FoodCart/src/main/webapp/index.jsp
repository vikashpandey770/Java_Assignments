<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html><html><head><title>Food Cart</title></head><body>
<h1>Food Cart</h1>
<form action="CartServlet" method="post">
Food Name: <input type="text" name="name" required><br><br>
Quantity: <input type="number" name="quantity" min="1" required><br><br>
<input type="submit" value="Add To Cart">
</form><br><a href="CartServlet">View Cart</a>
</body></html>
