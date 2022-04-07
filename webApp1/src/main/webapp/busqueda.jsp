<%-- 
    Document   : busqueda
    Created on : 22-mar-2022, 14:47:05
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados busqueda</title>
    </head>
    <body>
        <center>${SYST_MESSAGE}</center>
        <a>User: ${USER_NAME} [${GO_BACK}]</a>

        <p>Videos encontrados:</p>
        <p>${FOUND_VIDEOS}</p>
    </body>
</html>
