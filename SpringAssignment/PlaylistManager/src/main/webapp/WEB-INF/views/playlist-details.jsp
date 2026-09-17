<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Playlist Details</title>
</head>
<body>
    <h1>Playlist Details</h1>

    <p><b>ID:</b> ${playlist.id}</p>
    <p><b>Name:</b> ${playlist.name}</p>
    <p><b>Description:</b> ${playlist.description}</p>

    <br>
    <a href="${pageContext.request.contextPath}/">Back to Playlist List</a>
</body>
</html>
