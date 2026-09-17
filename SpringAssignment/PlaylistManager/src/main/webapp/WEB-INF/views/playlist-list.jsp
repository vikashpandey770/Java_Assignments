<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Playlist Manager</title>
</head>
<body>
    <h1>Playlist Manager</h1>

    <a href="${pageContext.request.contextPath}/add">Add New Playlist</a>

    <h2>All Playlists</h2>

    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Playlist Name</th>
            <th>Description</th>
        </tr>

        <c:forEach var="p" items="${playlists}">
            <tr>
                <td>${p.id}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/playlist/${p.id}">
                        ${p.name}
                    </a>
                </td>
                <td>${p.description}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
