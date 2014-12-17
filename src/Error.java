import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Error extends HttpServlet {

    /**
     * Calls doPost
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Gets the PrintWriter from the response and prints the HTML to show the error page
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String back = (String) request.getAttribute("previous");
        out.println(
        "<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
        "<meta charset=\"utf-8\">" +
        "<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"/>" +
        "<title>Error</title>" +
        "</head>" +
        "<body>" +
        "<section id=\"error\">" +
        "<h1>Error has occurred</h1>" +
        "<p>Click retry to go back and try again.</p>" +
        "<p>Error: " + request.getAttribute("error") + "</p>" +
        "<a href=" + request.getAttribute("previous") + ">Retry</a>" +
        "</section>" +
        "</body>" +
        "</html>"
        );
    }
}
