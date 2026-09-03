package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Movieloginservlet
 */
@WebServlet("/Movieloginservlet")
public class Movieloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String username=request.getParameter("username");
String password=request.getParameter("12345");

String correctUsername="vikash";
String correctPassword="12345";
if(correctUsername.equals(username)&& correctPassword.equals(password)) {
	
	response.sendRedirect("MovieDashboardServlet");
}
else {
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("invalid username or password");
}
	
	}

}
