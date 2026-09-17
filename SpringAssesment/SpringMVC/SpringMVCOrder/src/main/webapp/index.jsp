<!DOCTYPE html><html><head><title>Food Order</title></head><body>
<h2>Place Food Order</h2>
<form action="${pageContext.request.contextPath}/orders/place" method="post">
Customer Name: <input type="text" name="customerName" required><br><br>
Restaurant Name: <input type="text" name="restaurantName" required><br><br>
Total Amount: <input type="number" name="totalAmount" step="0.01" required><br><br>
Status: <select name="status"><option>PENDING</option><option>CONFIRMED</option><option>DELIVERED</option></select><br><br>
<button type="submit">Place Order</button>
</form><br><a href="${pageContext.request.contextPath}/orders/list">View All Orders</a>
</body></html>
