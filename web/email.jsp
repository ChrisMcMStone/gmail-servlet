<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles.css"/>
    <title>Send an E-Mail</title>
</head>

<body>
<div id="logout">
    <form action="logout" method="post">
        <input align="right" type="submit" value="Log Out"/>
    </form>
</div>
<div>
    <div>
        <h1>Send an E-Mail</h1>

        <p>Input the required fields below and click send!</p>
    </div>
    <br>
</div>


<form action="SendEmailController" method="post">
    <table>
        <tr>
            <td align="right">
                <b>To: </b>
            </td>
            <td>
                <input id="to" name="recipient" type="email" placeholder="example@gmail.com">
            </td>
        </tr>
        <tr>
            <td align="right">
                <b>Subject: </b>
            </td>
            <td>
                <input id="subject" name="subject" type="text" placeholder="...">
            </td>
        </tr>
        <tr>
            <td align="right">
                <b>Message: </b>
            </td>
            <td>
                <textarea id="message" name="message" placeholder="..."></textarea>
            </td>
        </tr>
        <tr>
            <td align="right">
                <input type="submit" value="Submit">
            </td>
            <td>
                <button type="reset" value="Reset">Reset</button>
            </td>
        </tr>
    </table>
</form>
<form action="SendEmailController" method="get">
    <input type="submit" value="Search">
</form>

</div>
</body>
</html>