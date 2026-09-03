package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/PlaylistServlets")
public class PlaylistServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   		String playlistId = request.getParameter("playlistId"); // Forward request to PlaylistDetailsServlet RequestDispatcher rd = request.getRequestDispatcher("/PlaylistDetailsServlet"); rd.forward(request, response); }
   	}
	
}
