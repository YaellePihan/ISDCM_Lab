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
        
        <!-- Video.js install-->
        <link href="https://vjs.zencdn.net/7.18.1/video-js.css" rel="stylesheet" />
    </head>
    <body>
        <h1>Main page</h1>
        <p>${USER_NAME}</p>
        <a href="servletRegistroVid">Subir video</a>
        <a href="login.jsp">Salir</a>
        <p> ${Table} </p>
        <br>
        <center>${SYST_MESSAGE}</center>
        <br>
        
        <video
        id="my-video"
        class="video-js"
        controls
        preload="auto"
        width="640"
        height="264"
        poster="MultiMedia/fons1.jpg"
        data-setup="{}"
        >
        <source src="MultiMedia/video1.mp4" type="video/mp4" />
        <source src="MY_VIDEO.webm" type="video/webm" />
        <p class="vjs-no-js">
        To view this video please enable JavaScript, and consider upgrading to a
        web browser that
        <a href="https://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
        </p>
        </video>
        <script src="https://vjs.zencdn.net/7.18.1/video.min.js"></script>
  
    </body>
</html>


<head>

  <!-- If you'd like to support IE8 (for Video.js versions prior to v7) -->
  <!-- <script src="https://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script> -->
</head>

<body>

</body>