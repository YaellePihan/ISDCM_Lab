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
        
        <!-- page data-->
        <p>${USER_NAME}</p>
        <center>${SYST_MESSAGE}</center>
        
        <!-- buttons -->
        <p> ${GOTO_UPLOAD_VID} </p>
        <p> ${GOTO_REPRODUCTION} </p>
        <p> ${GOTO_LOGOUT} </p>
        
        <!-- table -->
        <p> ${Table} </p>
        <br>
        <br>
    </body>
</html>


<head>

  <!-- If you'd like to support IE8 (for Video.js versions prior to v7) -->
  <!-- <script src="https://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script> -->
</head>

<body>

</body>