
package javaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TrendingSearchServlet")
public class TrendingSearchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        var context = getServletContext();
        List<String> trending =
                (List<String>) context.getAttribute("trendingKeywords");
        if (trending == null) {
            trending = new ArrayList<>();
            trending.add("iPhone 16");
            trending.add("samsung galaxy");
            trending.add("laptop");
            trending.add("smart watch");
            trending.add("bbuetooth earphones");
            context.setAttribute("trendingKeywords", trending);
        }
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Trending searches</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Trending searches</h2>");
        out.println("<ul>");
        for (String keyword:trending) {
            out.println("<li>"+keyword+"</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}

