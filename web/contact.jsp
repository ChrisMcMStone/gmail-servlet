<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search for/Add contact</title>
</head>
<body>
<center>
    <div align="right">
        <form action="LogoutController" method="post">
            <input align="right" type="submit" value="Log Out"/>
        </form>
        <div align="left">
            <a href="email.jsp">Back</a>
        </div>
    </div>
    <div>
        <div>
            <h1>Search for a contact</h1>

            <p>Enter a forename or surname and click search!</p>
        </div>
        <br>
    </div>
    <form action="SearchContactController" method="post">
        <table>
            <tr>
                <td align="right">
                    <b>Forename: </b>
                </td>
                <td>
                    <input id="name" name="forename" type="text" placeholder="...">
                </td>
            </tr>
            <tr>
                <td align="right">
                    <b>Surname: </b>
                </td>
                <td>
                    <input id="surname" name="surname" type="text" placeholder="...">
                </td>
            </tr>
            <tr>
                <td>
                    <b>Search by: </b>
                </td>
                <td>
                    <select name="searchtype">
                        <option value="forename">Forename</option>
                        <option value="familyname">Surname</option>
                    </select>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td align="right">
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </form>
    <%=request.getSession().getAttribute("results")%>
    <br>
    <br>
    <br>

    <div>
        <div>
            <h1>Add a contact</h1>

            <p>Enter a forename, surname and email and click add!</p>
        </div>
        <br>
    </div>

    <form action="AddContactController" method="post">
        <table>
            <tr>
                <td align="right">
                    <b>Forename: </b>
                </td>
                <td>
                    <input id="name" name="firstname" type="text" placeholder="...">
                </td>
            </tr>
            <tr>
                <td align="right">
                    <b>Surname: </b>
                </td>
                <td>
                    <input id="surname" name="secondname" type="text" placeholder="...">
                </td>
            </tr>
            <tr>
                <td align="right">
                    <b>Email Address: </b>
                </td>
                <td>
                    <input id="email" name="email" type="email" placeholder="...">
                </td>
            </tr>
            <tr>
                <td align="right">
                    <input type="submit" value="Submit">
                </td>
            </tr>
            <tr>
                <%=request.getSession().getAttribute("succeess")%>
            </tr>
        </table>
    </form>
    </div>
</center>
</body>
</html>
