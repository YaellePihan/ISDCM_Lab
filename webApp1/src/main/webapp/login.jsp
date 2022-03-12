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
        <title>JSP Login Page</title>
        <link rel="stylesheet" href="style1.css">
    </head>
    <body>
    <p>${SYST_MESSAGE}</p>
    <form action="servletUsuarios?login" method="post">
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
    </ul>
    </form>
    
    <li>
        <a href="registroUsu.jsp">Create account</a>
    </li>
    </body>
</html>
