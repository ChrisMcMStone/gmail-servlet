<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles.css"/>
    <title>Send an E-Mail</title>
</head>

<body>
<div class="logout-container">
    <form action="logout" method="post">
        <input id="logout" type="submit" value="Log Out"/>
    </form>
</div>
<section class="main">
    <h1>Send an E-Mail</h1>

    <p>Input the required fields below and click send!</p>

    <form action="sendemail" method="post">
        <table class="form-table">
            <tr>
                <td>
                    <b>To: </b>
                </td>
                <td>
                    <input value="<%=request.getAttribute("recipient")%>" class="input" name="recipient" type="email" placeholder="example@gmail.com">
                </td>
                <td>
                    <input id="find" name="search" type="submit" value="  ">
                </td>
                <td>
                    <input id="addcontact" name="add" type="submit" value="  ">
                </td>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Subject: </b>
                </td>
                <td>
                    <input class="input" name="subject" type="text" placeholder="...">
                </td>
            </tr>
            <tr>
                <td>
                    <b>Message: </b>
                </td>
                <td>
                    <textarea class="input" name="message" placeholder="..."></textarea>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="submit" value="Send">
                    <button type="reset" value="Reset">Reset</button>
                </td>
            </tr>
        </table>
    </form>
</section>
</body>
</html>