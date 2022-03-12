<%-- 
    Document   : registrationPage
    Created on : 01-mar-2022, 17:29:30
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" href="style1.css">
    </head>
    
    <body>
    <form action="servletUsuarios?register" method="Post"> <!-- action="/isdcm-lab1-form" -->
    <ul>
        <center>${SYST_MESSAGE}</center>
        <br>

        <li>
        <label for="name">Nombre:</label>
        <input type="text" id="name" name="user_name">
        </li>

        <li>
        <label for="surname">Apellidos:</label>
        <input type="text" id="surnames" name="user_surnames">
        </li>

        <li>
        <label for="mail">Correo electrónico:</label>
        <input type="email" id="mail" name="user_email">
        </li>
        
        <li>
        <label for="usernick">Nombre usuario:</label>
        <input type="text" id="usernick" name="user_nick">
        </li>

        <li>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="user_password">
        </li>

        <li>
        <label for="password2">Repetir Contraseña:</label>
        <input type="password" id="userpassword2" name="user_password2">
        </li>

        <li class="button">
        <button type="submit">Registrar usuario</button>
        </li>        
    </ul>
    </form>
    
    <br>
    <center> <a href="login.jsp">Have an account</a> </center>

</body>

</html>
