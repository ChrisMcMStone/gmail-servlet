import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chris on 08/12/14.
 */

@WebServlet("/sendemail")
public class SendEmail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (System.currentTimeMillis() > (request.getSession().getLastAccessedTime() + 300000)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error");    //New Request Dispatcher
            request.setAttribute("error", "Login session timed out, please click retry to log back in");
            request.setAttribute("previous", "index.html");
            dispatcher.forward(request, response);    //Forwards to the page
        } else {
            try {
                if (request.getParameter("search") != null) {
                    request.getSession().setAttribute("results", "");
                    request.getSession().setAttribute("success", "");
                    request.getRequestDispatcher("contact.jsp").forward(request, response);
                } else if (request.getParameter("add") != null) {
                    request.getSession().setAttribute("results", "");
                    request.getSession().setAttribute("success", "");
                    request.getRequestDispatcher("addcontact.jsp").forward(request, response);
                } else {
                    Session session = (Session) request.getSession().getAttribute("session");
                    String user = session.getProperties().getProperty("mail.user");
                    String password = session.getProperties().getProperty("mail.password");
                    String to = request.getParameter("recipient");
                    String subject = request.getParameter("subject");
                    String content = request.getParameter("message");

                    MimeMessage message = new MimeMessage(session);            //Creates new message
                    message.setFrom(new InternetAddress(user));            //Sets the sender
                    message.setRecipients(Message.RecipientType.TO, to);    //Sets the recipient
                    message.setSubject(subject);                            //Sets the subject
                    message.setText(content);                                //Sets the content

                    Transport tr = session.getTransport("smtp");
                    tr.connect("smtp.gmail.com", user, password);

                    tr.sendMessage(message, message.getAllRecipients());    //Sends the message

                    response.sendRedirect("sent.html");
                }

            } catch (Exception e) {

                RequestDispatcher dispatcher = request.getRequestDispatcher("Error");    //New Request Dispatcher

                request.setAttribute("error", e.getMessage());
                request.setAttribute("previous", "email.jsp");

                dispatcher.forward(request, response);    //Forwards to the page
            }
        }
    }
}
