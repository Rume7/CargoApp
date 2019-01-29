<%-- 
    Document   : welcome
    Created on : Jan 20, 2019, 6:39:34 PM
    Author     : E238958
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Welcome Page</title>
    </head>
    <body>
        <nav><a href="login.jsp">Logout</a></nav>
        <h2>Hallo ${newClient.userName}, you have successfully logged in </h2>
        <p>
            The statuses of your items are shown below.
        </p>

        <form action="items" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td>Email Address </td>
                        <td><input type="email" name="emailAdd" value="${newClient.email}" /></td>
                    </tr>
                    <tr>
                        <td>Item Name</td>
                        <td><input type="text" name="itemName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td><input type="text" name="quantity" value="1" /></td>
                    </tr>
                    <tr>
                        <td>Current Location</td>
                        <td><input type="text" name="currentLocationOfGood" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submitButton" value="SUBMIT" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
