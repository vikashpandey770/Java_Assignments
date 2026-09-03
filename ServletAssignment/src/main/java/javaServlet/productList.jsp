<%-- VIEW: only display logic here. No JDBC, no business rules. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f1f3f6; margin: 0; }
        .grid { display: flex; flex-wrap: wrap; gap: 16px; padding: 20px; }
        .card {
            width: 200px; background: #fff; border-radius: 6px; padding: 12px;
            box-shadow: 0 1px 4px rgba(0,0,0,0.15); text-align: center;
        }
        .card img { width: 100%; height: 140px; object-fit: contain; }
        .price { color: #388e3c; font-weight: bold; margin-top: 6px; }
        .category { color: #888; font-size: 12px; }
        h2 { padding: 15px 20px 0; color: #2874f0; }
    </style>
</head>
<body>
    <h2>Product Listing</h2>
    <div class="grid">
        <%
            // The Controller already put the list into request scope.
            // The JSP only loops and displays it — no fetching happens here.
            List<Product> productList = (List<Product>) request.getAttribute("productList");

            if (productList != null && !productList.isEmpty()) {
                for (Product p : productList) {
        %>
                <div class="card">
                    <img src="<%= p.getImageUrl() %>" alt="<%= p.getName() %>">
                    <h4><%= p.getName() %></h4>
                    <p class="category"><%= p.getCategory() %></p>
                    <p class="price">&#8377; <%= p.getPrice() %></p>
                </div>
        <%
                }
            } else {
        %>
                <p>No products found.</p>
        <%
            }
        %>
    </div>
</body>
</html>
