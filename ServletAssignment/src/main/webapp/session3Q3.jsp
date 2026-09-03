<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="FeedbackServlet" method="post"> 
<label>User Name:</label>
 <input type="text" name="userName">
  <br><br>
   <label>Order ID:</label> 
   <input type="text" name="orderId"> 
   <br><br> 
   <label>Feedback:</label> 
   <textarea name="feedback" rows="5" cols="30"></textarea>
    <br><br>
     <input type="submit" value="Submit Feedback"> 
     
     </form>
</body>
</html>