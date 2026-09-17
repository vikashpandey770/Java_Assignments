<!DOCTYPE html>
<html><head><title>Order Management</title></head><body>
<h2>Place Food Order</h2>
<form action="orders" method="post">
    Customer Name: <input type="text" name="customerName" required><br><br>
    Restaurant Name: <input type="text" name="restaurantName" required><br><br>
    Total Amount: <input type="number" name="totalAmount" step="0.01" min="0" required><br><br>
    Status:
    <select name="status">
        <option value="PENDING">PENDING</option>
        <option value="CONFIRMED">CONFIRMED</option>
        <option value="DELIVERED">DELIVERED</option>
    </select><br><br>
    <button type="submit">Place Order</button>
</form>
<br><a href="orders">View All Orders</a>
</body></html>
