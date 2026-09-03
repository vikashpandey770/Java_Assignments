package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ordersummery")
public class ordersummery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setAttribute("itemname", "laptop");
		request.setAttribute("quantiity",2);
		request.setAttribute("price", 1500);
	
		request.getRequestDispatcher("Session7Q4.jsp").forward(request, response);
		
	}

}
