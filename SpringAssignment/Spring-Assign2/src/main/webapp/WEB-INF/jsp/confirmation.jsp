<!DOCTYPE html>
<html>

<head>

    <title>Song Confirmation</title>

</head>

<body>

    <h1>Song Saved Successfully!</h1>

    <hr>

    <h3>Song Details</h3>

    <p>
        <strong>Song Name:</strong>
        ${songName}
    </p>

    <p>
        <strong>Artist:</strong>
        ${artist}
    </p>


    <br>

    <a href="${pageContext.request.contextPath}/addSong.action">
        Add Another Song
    </a>

</body>

</html>