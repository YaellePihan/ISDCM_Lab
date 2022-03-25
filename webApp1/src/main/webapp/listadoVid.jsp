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
        <h2>Video List</h2>
        
        <!-- buttons -->
        <p> [ ${GOTO_UPLOAD_VID} ] [ ${GOTO_REPRODUCTION} ] [ ${GOTO_LOGOUT} ]</p>
        
        <!-- page and user data-->
        <center>${SYST_MESSAGE}</center>
        <p>User: ${USER_NAME}</p>
        
        <!-- table -->
        <p> ${Table} </p>
        <br>
        <br>
    </body>
</html>