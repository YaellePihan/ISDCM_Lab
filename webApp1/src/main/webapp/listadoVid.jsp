<%-- 
    Document   : listadoVid
    Created on : 12-mar-2022, 13:54:02
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Listado Videos Page</title>
        <link rel="stylesheet" href="style1.css">
    </head>
    <body>
        
        <!-- page and user data + buttons -->
        <center>${SYST_MESSAGE}</center>
        <center>User: ${USER_NAME} [${GOTO_UPLOAD_VID}] [${GOTO_REPRODUCTION}] [${GOTO_LOGOUT}]</center>
        <br>
        
        <!-- searcher -->
        <form action="servletREST" method="get">
            <label>Buscador:</label> <br>
            <label for="video_searcher_title">Titulo:</label>
            <input type="text" id="videosearchtitle" name="video_search_title">
            
            <label for="video_searcher_author">Autor:</label>
            <input type="text" id="videosearchauthor" name="video_search_author">
            
            <label for="video_searcher_date">Fecha (dd/mm/yyy):</label>
            <input type="text" id="videosearchdate" name="video_search_date">
            
            <button type="submit">Busca</button>
        </form>
        <br>
        
        <!-- table -->
        <h3>Video List</h3>
        <p> ${Table} </p>
        
    </body>
</html>