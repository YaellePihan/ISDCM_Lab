<%-- 
    Document   : login
    Created on : 01-mar-2022, 17:54:24
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style1.css">
    </head>
    <body>
    <form action="/isdcm-lab1-form" method="post">
    <ul>
        <li>
        <label for="usernick">Nombre usuario:</label>
        <input type="text" id="usernick" name="user_nick">
        </li>

        <li>
        <label for="password">Contraseña:</label>
        <input type="text" id="password" name="user_password">
        </li>

        <li class="button">
        <button type="submit">Entra</button>
        </li>
        
        <li>
            <a href="registroUsu.jsp">Create account</a>
        </li>

       </form>
    </body>
</html>
