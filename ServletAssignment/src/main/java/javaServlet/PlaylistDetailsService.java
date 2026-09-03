
package javaServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PlaylistDetailsServlet")
public class PlaylistDetailsService extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get playlistId from forwarded request
        String playlistId = request.getParameter("playlistId");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Playlist Details</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Playlist Details</h2>");
        out.println("<p>Playlist ID: " + playlistId + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}

