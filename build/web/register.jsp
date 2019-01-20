<%-- 
    Document   : register
    Created on : Jan 20, 2019, 2:51:39 PM
    Author     : E238958
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>

        <h2>Registration Form Details</h2>

        <form action="register" method="POST">
            <table>
                <thead>
                    <tr>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" value="" required="true" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" value="" required="true" /></td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" value="" required="true" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="password" value="" required="true" /></td>
                    </tr>
                    <tr>
                        <td>Confirm password</td>
                        <td><input type="password" name="confirmPassword" value="" required="true" /></td>
                    </tr>
                    <tr>
                        <td>Email Address</td>
                        <td><input type="email" name="emailAddress" value="" required="true" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="registerButton" value="REGISTER" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
