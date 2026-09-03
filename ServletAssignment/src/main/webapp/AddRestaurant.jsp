<%-- AddRestaurant.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Restaurant</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f5f5f5; }
        .form-box {
            width: 350px; margin: 60px auto; background: #fff;
            padding: 25px; border-radius: 8px; box-shadow: 0 0 10px #ccc;
        }
        h2 { color: #cb202d; text-align: center; }
        label { font-weight: bold; display: block; margin-top: 12px; }
        input[type=text] {
            width: 100%; padding: 8px; margin-top: 5px;
            border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;
        }
        input[type=submit] {
            margin-top: 20px; width: 100%; padding: 10px;
            background: #cb202d; color: #fff; border: none;
            border-radius: 4px; cursor: pointer; font-size: 16px;
        }
        input[type=submit]:hover { background: #a91a24; }
        .msg { color: green; text-align: center; font-weight: bold; }
    </style>
</head>
<body>
    <div class="form-box">
        <h2>Add Restaurant</h2>

        <%-- Show success/error message coming back from servlet, if any --%>
        <% if (request.getAttribute("message") != null) { %>
            <p class="msg"><%= request.getAttribute("message") %></p>
        <% } %>

        <form action="AddRestaurantServlet" method="post">
            <label for="name">Restaurant Name:</label>
            <input type="text" id="name" name="name" placeholder="e.g. Domino's Pizza" required>

            <label for="cuisine">Cuisine Type:</label>
            <input type="text" id="cuisine" name="cuisine" placeholder="e.g. Italian, Chinese" required>

            <input type="submit" value="Add Restaurant">
        </form>
    </div>
</body>
</html>
