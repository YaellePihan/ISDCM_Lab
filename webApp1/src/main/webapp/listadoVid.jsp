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
        <form action="servletREST" method="post">
            <label for="video_searcher">Buscador:</label>
            <input type="text" id="videosearch" name="video_search">
            <button type="submit">Busca</button>
        </form>
        <br>
        
        <!-- table -->
        <h3>Video List</h3>
        <p> ${Table} </p>
        
    </body>
</html>