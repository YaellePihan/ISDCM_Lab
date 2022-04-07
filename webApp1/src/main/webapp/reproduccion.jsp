<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Video Reproductor</title>
        <!-- Video.js install-->
        <link href="https://vjs.zencdn.net/7.18.1/video-js.css" rel="stylesheet" />
    </head>
    <body>
        <center>${SYST_MESSAGE}</center>
        
        <!-- user data and buttons-->
        <a>User: ${USER_NAME} [${GO_BACK}]</a>
        <br>
        
        <!-- video reproducer -->
        <center>
        <video id="my-video" class="video-js" controls preload="auto" width="640" height="264" poster="MultiMedia/fons1.jpg" data-setup="{}" >
        <source src="MultiMedia/video1.mp4" type="video/mp4" />
        <source src="MY_VIDEO.webm" type="video/webm" />
        <p class="vjs-no-js"> To view this video please enable JavaScript, and consider upgrading to a web browser that
        <a href="https://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a> </p>
        </video>
        <script src="https://vjs.zencdn.net/7.18.1/video.min.js"></script> 
        </center>
        
        <!-- video info-->
        <p> <b> ${VID_TITLE} </b> </p>
        <p>Vistas: ${VID_VIEWS} , Creation date: ${VID_CREATION_DATE} , Author: ${VID_AUTHOR}</p>

    </body>
</html>
