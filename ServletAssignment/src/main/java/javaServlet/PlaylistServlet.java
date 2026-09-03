
package javaServlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class PlaylistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String defaultGenre;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        defaultGenre = config.getInitParameter("defaultGenre");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Playlist</title></head>");
        out.println("<body>");
        out.println("<h2>Welcome to Playlist</h2>");
        out.println("<p>Default Playlist Genre: " + defaultGenre + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
