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
        <title>Welcome Page</title>
    </head>
    <body>
        
        <h2>Congratulations <% request.getParameter("username"); %>, you have successfully logged in ...</h2>
        
    </body>
</html>
