<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Playlist</title>
</head>
<body>
    <h1>Add New Playlist</h1>

    <form action="${pageContext.request.contextPath}/save" method="post">
        <label>Playlist Name:</label>
        <input type="text" name="name" required>
        <br><br>

        <label>Description:</label>
        <textarea name="description" required></textarea>
        <br><br>

        <input type="submit" value="Save Playlist">
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/">Back to Playlist List</a>
</body>
</html>
