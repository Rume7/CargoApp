<%-- 
    Document   : login
    Created on : Jan 20, 2019, 2:51:27 PM
    Author     : E238958
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login Details</h2>

        <form action="login" method="POST">
            <table>
                <thead>
                    <tr>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Email: </td>
                        <td><input type="email" name="email" value="" required="true" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="password" value="" required="true" /></td>
                    </tr>
                     <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="loginButton" value="LOGIN" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
