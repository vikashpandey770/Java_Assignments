package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/playlist")
public class PlaylistServlett extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h2>My Favorite Spotify Playlists</h2>");

        out.println("<ul>");
        out.println("<li>Today's Top Hits</li>");
        out.println("<li>Chill Hits</li>");
        out.println("<li>Top Bollywood Hits</li>");
        out.println("</ul>");
    }
}