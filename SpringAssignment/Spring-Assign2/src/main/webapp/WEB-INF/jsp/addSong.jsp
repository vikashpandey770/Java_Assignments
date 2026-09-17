<!DOCTYPE html>
<html>

<head>

    <title>Add Song</title>

</head>

<body>

    <h1>Add Song</h1>

    <form action="${pageContext.request.contextPath}/saveSong.action"
          method="post">

        <label>Song Name:</label>

        <input type="text"
               name="songName"
               required>

        <br><br>


        <label>Artist:</label>

        <input type="text"
               name="artist"
               required>

        <br><br>


        <input type="submit"
               value="Save Song">

    </form>

</body>

</html>