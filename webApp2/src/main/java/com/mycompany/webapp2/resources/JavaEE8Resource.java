package com.mycompany.webapp2.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import java.util.List;

import video.video;

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
    public String increaseViewsFunc(@DefaultValue("noVideoID") @FormParam("VideoiD") String videoID)
    {
       String ret = "a1";
       
       return ret;
    }

    
    @Path("searchVideo")
    @GET
    //@Produces("application/json")
    @Produces("text/plain")
    public String searchVideo(@QueryParam("title") String title,
                              @QueryParam("author") String author,
                              @QueryParam("date") String date)
    {
        String ret = " a2 ";
        ret += title + " ";
        ret += author + " ";
        ret += date + " ";
        // List<video> videos;
        
        return ret;
    }
}
