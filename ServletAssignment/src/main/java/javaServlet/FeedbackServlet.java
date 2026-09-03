package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName"); 
		String orderId = request.getParameter("orderId");
		String feedback = request.getParameter("feedback");
		response.setContentType("text/html"); 
		
		PrintWriter  out = response.getWriter();
		
		if(userName==null||userName.trim().isEmpty()||orderId==null||orderId.trim().isEmpty()||feedback==null||feedback.trim().isEmpty())
		{
			
		out.println("<h2>Feedback Submitted Not Successfully! </h2>");
		}
		else {
		out.println("<p>User Name: " + userName + "</p>"); 
		out.println("<p>Order ID: " + orderId + "</p>");
		out.println("<p>Feedback: " + feedback + "</p>");
		}
	}
	

	

}
