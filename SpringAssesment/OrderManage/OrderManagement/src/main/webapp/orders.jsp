<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html><head><title>All Orders</title></head><body>
<h2>All Orders</h2>
<c:choose>
  <c:when test="${empty orders}"><p>No orders found.</p></c:when>
  <c:otherwise>
    <table border="1" cellpadding="10">
      <tr><th>ID</th><th>Customer</th><th>Restaurant</th><th>Total Amount</th><th>Status</th></tr>
      <c:forEach var="o" items="${orders}">
        <tr>
          <td>${o.orderId}</td><td>${o.customerName}</td><td>${o.restaurantName}</td>
          <td>₹${o.totalAmount}</td><td>${o.status}</td>
        </tr>
      </c:forEach>
    </table>
  </c:otherwise>
</c:choose>
<br><a href="index.jsp">Place New Order</a>
</body></html>
