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
        <h1>Main page</h1>
        <a href="servletRegistroVid">Subir video</a>
        <a href="login.jsp">Salir</a>
        <p> ${Table} </p>
        <br>
        <center>${SYST_MESSAGE}</center>
        <br>
        
    </body>
</html>