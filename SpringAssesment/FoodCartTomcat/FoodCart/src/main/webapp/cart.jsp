<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head><title>My Food Cart</title></head><body>
<h1>My Food Cart</h1>
<c:choose>
<c:when test="${empty sessionScope.cart}"><h3>Your cart is empty.</h3></c:when>
<c:otherwise>
<table border="1" cellpadding="10"><tr><th>No.</th><th>Food Item</th></tr>
<c:forEach var="item" items="${sessionScope.cart}" varStatus="status"><tr><td>${status.index + 1}</td><td>${item}</td></tr></c:forEach>
</table><br>
<form action="CartServlet" method="post"><input type="hidden" name="action" value="clear"><input type="submit" value="Clear Cart"></form>
</c:otherwise></c:choose><br><a href="index.jsp">Add More Food</a>
</body></html>
