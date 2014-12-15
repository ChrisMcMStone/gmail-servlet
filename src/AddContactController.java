import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by chris on 09/12/14.
 */

/**
 * Servlet for adding contacts
 */
public class AddContactController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Checks whether session has timed out
        if (System.currentTimeMillis() > (request.getSession().getLastAccessedTime() + 300000)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error");    //New Request Dispatcher
            request.setAttribute("error", "Login session timed out, please click retry to log back in");
            request.setAttribute("previous", "index.jsp");
            dispatcher.forward(request, response);    //Forwards to the page
        } else {

            HttpSession httpSession = request.getSession();     //Get Session details
            Session session = (Session) httpSession.getAttribute("session");
            String user = session.getProperties().getProperty("mail.user");

            String forename = request.getParameter("firstname");
            String surname = request.getParameter("secondname");
            String email = request.getParameter("email");

            Model m = new Model(user);      //Initialize model

            try {
                httpSession.setAttribute("succeess", "Contact saved successfully");
                m.addContact(forename, surname, email, user);
                request.getRequestDispatcher("contact.jsp").forward(request, response);
            } catch (SQLException e) {

                //Cath errors
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
