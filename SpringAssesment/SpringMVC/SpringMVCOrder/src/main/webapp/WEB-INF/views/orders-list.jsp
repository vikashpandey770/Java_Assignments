<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head><title>Orders List</title><style>body{font-family:Arial;margin:40px}table{border-collapse:collapse;width:100%}th,td{border:1px solid #999;padding:10px;text-align:left}th{background:#eee}.btn{display:inline-block;margin-bottom:20px;padding:8px 14px;border:1px solid #555;text-decoration:none}</style></head><body>
<h2>All Food Delivery Orders</h2><a class="btn" href="${pageContext.request.contextPath}/">Place New Order</a>
<table><tr><th>Order ID</th><th>Customer</th><th>Restaurant</th><th>Total Amount</th><th>Status</th></tr>
<c:forEach var="o" items="${orders}"><tr><td>${o.orderId}</td><td>${o.customerName}</td><td>${o.restaurantName}</td><td>₹ ${o.totalAmount}</td><td>${o.status}</td></tr></c:forEach>
<c:if test="${empty orders}"><tr><td colspan="5">No orders found.</td></tr></c:if></table>
</body></html>
