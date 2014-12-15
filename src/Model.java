import java.sql.*;
import java.util.ArrayList;

/**
 * Created by chris on 08/12/14.
 */
public class Model {

    private String DBNAME = "jdbc:postgresql://dbteach2.cs.bham.ac.uk/cxm373";
    private String USERNAME = "cxm373";
    private String PASSWORD = "computer2014";
    private String emailUser;
    private Connection conn;

    public Model(String username) {
        emailUser = username;
        conn = connect();
    }

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            System.exit(0);
        }

        System.out.println("PostgreSQL driver registered.");

        Connection dbConn = null;

        try {
            dbConn = DriverManager.getConnection(DBNAME, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (dbConn != null) {
            System.out.println("Connected to database successfully.");
        } else {
            System.out.println("Database connection failed.");
        }
        return dbConn;

    }

    public String search(String query, String search, String contactemail) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM contactinfo WHERE " + search + " = '" + query + "' and contactemailaddress = '" + contactemail + "'");
        ResultSet rs = ps.executeQuery();
        StringBuilder result = new StringBuilder("<table>" +
                "<tr>" +
                "<td>FirstName</td> <td>Surname</td> <td>Email</td>" +
                "</tr>");
        while (rs.next()) {
            result.append("<tr><td>");
            result.append(rs.getString(2));
            result.append("</td><td>" + rs.getString(3));
            result.append("</td><td>" + rs.getString(4) + "</td></tr>");
        }
        result.append("</table");
        return result.toString();
    }

    public void addContact(String firstname, String surname, String email, String user) throws SQLException {
        PreparedStatement newStudent = conn.prepareStatement("INSERT INTO " +
                "contactinfo (forename, familyname, emailaddress, contactemailaddress) VALUES ('" + firstname + "', '" + surname + "', '" + email + "', '" + user + "')");
        newStudent.execute();
    }
}