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
        <h2>Congratulations ${newClient.userName}, you have successfully logged in </h2>
        <p>
            The statuses of your items are shown below.
        </p>
        
        <table>
            <thead>
                <tr>
                    <td><b>S/N</b></td>
                    <td><b>Item</b></td>
                    <td><b>Status</b></td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Camera</td>
                    <td>Ready for pickup</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Mac Book Pro</td>
                    <td>Ready for pickup</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Sofa</td>
                    <td>Not in country</td>
                </tr>
                
                <tr>
                    <td>4</td>
                    <td>IPad</td>
                    <td>Not available</td>
                </tr>
            </tbody>
        </table>
        
    </body>
</html>
