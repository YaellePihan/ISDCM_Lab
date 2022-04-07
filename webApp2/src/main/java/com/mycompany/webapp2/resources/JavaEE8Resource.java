package com.mycompany.webapp2.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import video.video;
import video.VideoSearcher;

@Path("javaee8")
public class JavaEE8Resource {

    @Path("increaseViews")
    @POST
    @Produces("text/plain")
    public int increaseViewsFunc(@FormParam("VideoID") int videoID)
    {
       VideoSearcher vS = new VideoSearcher();
       int ret = vS.sumView(videoID);
       
       return ret;
    }
    
    @Path("searchVideo")
    @GET
    @Produces("application/json")
    public String searchVideo(@QueryParam("title") String title,
                              @QueryParam("author") String author,
                              @QueryParam("date_d") String date_d,
                              @QueryParam("date_m") String date_m,
                              @QueryParam("date_y") String date_y)
    {
        String ret = "";

        VideoSearcher vS = new VideoSearcher();
        int date_d_int = Integer.valueOf(date_d);
        int date_m_int = Integer.valueOf(date_m);
        int date_y_int = Integer.valueOf(date_y);
        String videosResult = vS.getVideoSearchList(title, author, date_d_int, date_m_int, date_y_int);
        
        ret += videosResult;
        return ret;
    }
}
