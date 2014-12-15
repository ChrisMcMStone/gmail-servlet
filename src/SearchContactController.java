import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by chris on 09/12/14.
 */

/**
 * Servlet for searching for contacts
 */
public class SearchContactController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Checks whether session has timed out
        if (System.currentTimeMillis() > (request.getSession().getLastAccessedTime() + 300000)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error");    //New Request Dispatcher
            request.setAttribute("error", "Login session timed out, please click retry to log back in");
            request.setAttribute("previous", "index.jsp");
            dispatcher.forward(request, response);    //Forwards to the page
        } else {
            HttpSession httpSession = request.getSession();
            Session session = (Session) httpSession.getAttribute("session");
            String user = session.getProperties().getProperty("mail.user");
            String searchType;
            String searchQueryName;
            if ("forename".equals(request.getParameter("searchtype"))) {
                searchType = "forename";
                searchQueryName = request.getParameter("forename");

            } else {
                searchType = "familyname";
                searchQueryName = request.getParameter("surname");
            }

            Model m = new Model(user);

            try {
                String resultTable = m.search(searchQueryName, searchType, user);
                httpSession.setAttribute("results", resultTable);
                httpSession.setAttribute("succeess", "");
                request.getRequestDispatcher("contact.jsp").forward(request, response);
            } catch (SQLException e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("Error"); //New Request Dispatcher
                request.setAttribute("error", e.getMessage());
                request.setAttribute("previous", "searchcontact");
                dispatcher.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

