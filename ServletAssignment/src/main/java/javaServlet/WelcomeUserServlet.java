package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/WelcomeUserServlet")
public class WelcomeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//response.sendRedirect("welcomeuser.jsp");
		
	}
	
	public void init()throws ServletException{
		System.out.println("init method is running");
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException, IOException{
		System.out.println("this is a service method call");
		super.service(req, res);
	}
	
	public void destroy() {
		
		System.out.println("destroy method");
	}

	// session 2 question 4 start code here.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
		
	String appName = getServletConfig().getInitParameter("appName");
	PrintWriter out = response.getWriter();
	
	}
	
	
	
}
