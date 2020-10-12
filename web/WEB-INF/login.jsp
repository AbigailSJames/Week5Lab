<%-- 
    Document   : login
    Created on : Oct 11, 2020, 10:14:25 PM
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
        <h1>Login</h1>
        <form method="post" action="Login">
            Username: <input type="text" name="username" value="${username}"><br>
            Password:<input type="text" name="pswd" value="${pswd}"><br>
            <input type="submit" name="action" value="Log in">
        </form>
            <p>${invalid}</p>
    </body>
</html>
