<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Search Song</h2> <form action="SongSearchServlet" method="get">
 <label>Song Name:</label>
  <input type="text" name="songName"> <br>
  <br> <label>Artist name:</label>
   <input type="text" name="artist"> <br>
   <br> <input type="submit" value="Search"> 
   </form>
</body>
</html>