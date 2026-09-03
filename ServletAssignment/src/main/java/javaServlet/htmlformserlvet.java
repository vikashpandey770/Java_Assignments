package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class htmlformserlvet
 */
@WebServlet("/htmlformserlvet")
public class htmlformserlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String songname=request.getParameter("songName");
		String artistname=request.getParameter("artistName");
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.println("<h2>Serch result</h2>");
		out.println("<p>song name: "+ songname+ "</p>");
		out.println("<p>artist name : "+artistname+"</p>");
		
		
 	
 	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
