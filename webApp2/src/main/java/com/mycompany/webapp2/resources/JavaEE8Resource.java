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
    
    /*
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
    @Path("getInfo")
    @GET    
    @Produces("text/html")
    public String getInfo (@QueryParam("info") String info, 
                            @QueryParam("fecha") String fecha) {
        
        return "<html><head></head> <body> Informaci&oacute;n recibida " + info + " en fecha " + fecha + " </body></html>";
    }
    
    @Path("postInfo")   
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String postInfo (  @FormParam("info") String info, 
                              @FormParam("fecha") String fecha) 
    {                
        return "<html><head></head> <body> Informaci&oacute;n recibida " + info + " en fecha " + fecha + " </body></html>";
    }
*/

    @Path("increaseViews")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/plain")
    public int increaseViewsFunc(@FormParam("VideoID") int videoID)
    {
       VideoSearcher vS = new VideoSearcher();
       int ret = vS.sumView(videoID);
       
       return ret;
    }

    
    @Path("searchVideo")
    @GET
    //@Produces("application/json")
    @Produces("application/json")
    public String searchVideo(@QueryParam("title") String title,
                              @QueryParam("author") String author,
                              @QueryParam("date_d") String date_d,
                              @QueryParam("date_m") String date_m,
                              @QueryParam("date_y") String date_y)
    {
        String ret = "";//" GET Search Video... ";

        VideoSearcher vS = new VideoSearcher();
        int date_d_int = Integer.valueOf(date_d);
        int date_m_int = Integer.valueOf(date_m);
        int date_y_int = Integer.valueOf(date_y);
        String videosResult = vS.getVideoSearchList(title, author, date_d_int, date_m_int, date_y_int);
        
        ret += videosResult;
        return ret;
    }
}
