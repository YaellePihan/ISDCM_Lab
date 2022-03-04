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
    </head>
    
    <body>
    <style>
        form {
            margin: 0 auto;
            width: 400px;
            padding: 1em;
            border: 1px solid #CCC;
            border-radius: 1em;
        }

        ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        form li + li {
            margin-top: 1em;
        }

        label {
            display: inline-block;
            width: 90px;
            text-align: right;
        }

        input,
        textarea {
            font: 1em sans-serif;
            width: 300px;
            box-sizing: border-box;
            border: 1px solid #999;
        }

        input:focus,
        textarea:focus {
            border-color: #000;
        }

        textarea {
            vertical-align: top;
            height: 5em;
        }

        .button {
            padding-left: 90px;
        }

        button {
            margin-left: .5em;
        }
    </style>

    <form action="/isdcm-lab1-form" method="post">
    <ul>
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
        <input type="email" id="mail" name="user_mail">
        </li>
        
        <li>
        <label for="usernick">Nombre usuario:</label>
        <input type="text" id="usernick" name="user_nick">
        </li>

        <li>
        <label for="password">Contraseña:</label>
        <input type="text" id="password" name="user_password">
        </li>

        <li>
        <label for="password2">Repetir Contraseña:</label>
        <input type="text" id="userpassword2" name="user_password2">
        </li>

        <li class="button">
        <button type="submit">Registrar usuario</button>
        </li>
        
        <li>
        <a href="login.jsp" method="POST">Have an account</a>
        </li>
        
        <a href="servletUsuarios"> Click to use servlet processRequest </a>
        <br>
        <a href="servletUsuarios" method="Post"> Click to use servlet POST </a>

       </form>
    </ul>
</body>

</html>
