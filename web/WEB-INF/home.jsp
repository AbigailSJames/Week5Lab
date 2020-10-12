<%-- 
    Document   : home
    Created on : Oct 11, 2020, 10:16:26 PM
    Author     : 818736
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        Hello ${user}
        <form method="get" action="login">
            <input type="submit" name="action" value="logout">
        </form>
    </body>
</html>
