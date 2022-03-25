<%-- 
    Document   : reproduccion
    Created on : 22-mar-2022, 14:47:30
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Video Reproductor</title>
        <!-- Video.js install-->
        <link href="https://vjs.zencdn.net/7.18.1/video-js.css" rel="stylesheet" />
    </head>
    <body>
        <center>${SYST_MESSAGE}</center>
        <a> ${USER_NAME}</a>
        <a> ${GO_BACK}</a>
        <a href="login.jsp">Go back old</a> <!-- TODO: FIX THIS -->
        <p>${VID_TITLE}</p>
        <p>${VID_AUTHOR}</p>
        <p>${VID_CREATION_DATE}</p>
        <p>${VID_VIEWS}</p>
        
        <video id="my-video" class="video-js" controls
        preload="auto" width="640" height="264"
        poster="MultiMedia/fons1.jpg" data-setup="{}" >
            
        <source src="MultiMedia/video1.mp4" type="video/mp4" />
        <source src="MY_VIDEO.webm" type="video/webm" />
        <p class="vjs-no-js"> To view this video please enable JavaScript, and consider upgrading to a web browser that
        <a href="https://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a> </p>
        </video>
        <script src="https://vjs.zencdn.net/7.18.1/video.min.js"></script>     

    </body>
</html>
