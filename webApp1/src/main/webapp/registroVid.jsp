<%-- 
    Document   : uploadvideo
    Created on : 12-mar-2022, 13:18:13
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Upload Video Page</title>
        <link rel="stylesheet" href="style1.css">
    </head>
    <body>
    <form action="servletRegistroVid?uploadvid" method="post">
    <ul>
        <li>
        <label for="usernick">Nombre de video:</label>
        <input type="text" id="videoname" name="video_name">
        </li>

        <li>
        <label for="password">Descripción de video:</label>
        <input type="text" id="videodescription" name="video_description">
        </li>
        
        <li>
        <label for="password">Autor:</label>
        <input type="text" id="videoauthor" name="video_author">
        </li>
        
        <li>
        <label for="password">Duracion:</label>
        <input type="text" id="videoduration" name="video_duration">
        </li>
        
        <li>
        <label for="myfile">Select a file:</label>
        <input type="file" id="myvideo" name="my_video"> 
        </li>

        <br>
        <button type="submit">Subir Video</button>
    </ul>
    </form>
    <center> <a href="servletListadoVid">Cancelar</a> </center>
    </body>
</html>
