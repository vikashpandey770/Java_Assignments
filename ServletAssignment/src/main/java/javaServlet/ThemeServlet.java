
package javaServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ThemeServlet")
public class ThemeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Get ServletContext
        ServletContext context = getServletContext();

        // Read default theme from web.xml
        String theme = context.getInitParameter("appTheme");

        // Read theme parameter from request URL
        String requestTheme = request.getParameter("theme");

        // If theme parameter is present and not empty,
        // override the default theme
        if (requestTheme != null && !requestTheme.trim().isEmpty()) {
            theme = requestTheme;
        }

        // Display result
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Theme Servlet</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Current App Theme: " + theme + "</h2>");

        out.println("</body>");
        out.println("</html>");
    }
}
