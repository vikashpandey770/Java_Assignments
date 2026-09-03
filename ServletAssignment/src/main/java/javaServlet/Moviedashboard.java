package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Moviedashboard")
public class Moviedashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Movie Dashboard</title>");
		out.println("</head>"); out.println("<body>");
		out.println("<h1>Welcome to Movie Dashboard!</h1>");
		out.println("<p>Login Successful.</p>");
		out.println("</body>"); out.println("</html>");
		
	}
	
}
