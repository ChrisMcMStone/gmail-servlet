<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Send an E-Mail</title>
</head>

<body>

<article class="login-container">
    <section class="login">
        <h1>Log into gMail</h1>

        <p>Input the required fields below to login.</p>

        <form action="LoginController" method="post">
            <div>
                <table>
                    <tr>
                        <td>
                            <b>GMail Username: </b>
                        </td>
                        <td>
                            <input id="subject" name="username" type="email" placeholder="example@gmail.com">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Password: </b>
                        </td>
                        <td>
                            <input id="password" name="password" type="password" placeholder="password">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit">
                        </td>
                        <td>
                            <button type="reset" value="Reset">Reset</button>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </section>
</article>
</body>
</html>
