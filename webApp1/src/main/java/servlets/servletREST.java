package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
//import java.io.OutputStream;

import java.net.URL;
import java.net.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;


@WebServlet(name = "servletREST", urlPatterns = {"/servletREST"})
public class servletREST extends HttpServlet {
    
    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Get Values
            String search_title     = request.getParameter("video_search_title");
            String search_author    = request.getParameter("video_search_author");
            String search_date_d    = request.getParameter("video_search_date_day");
            String search_date_m    = request.getParameter("video_search_date_month");
            String search_date_y    = request.getParameter("video_search_date_year");
            
            if (!CheckDateValues(search_date_d, search_date_m, search_date_y))
            {
                // TODO: Fix that!
                RequestDispatcher reqDisp = request.getRequestDispatcher("listadoVid.jsp");
                request.setAttribute("SYST_MESSAGE", "Invalid date!");
                reqDisp.forward(request, response);
            }
            else
            {
               // Generate URL
               String urlToAsk = "http://localhost:8080/webApp2/resources/javaee8/searchVideo?";
               String requestParameters = "title=" + search_title + "&author=" + search_author + "&date_d=" + search_date_d + "&date_m=" + search_date_m + "&date_y=" + search_date_y;
               urlToAsk += requestParameters;

               // Create connection
               URL getVideoListURL = new URL(urlToAsk);
               HttpURLConnection http_connection = (HttpURLConnection)getVideoListURL.openConnection();
               http_connection.setRequestMethod("GET");
               http_connection.setRequestProperty("Accept", "text/plain");

               if(http_connection.getResponseCode() != 200)
               {
                   // TODO: Add error message
               }

               // Get Result
               BufferedReader read = new BufferedReader(new InputStreamReader(http_connection.getInputStream(), "utf-8"));
               String outputPart = read.readLine();
               String finalOutput = null;
               while(outputPart != null)
               {
                   finalOutput += outputPart + "<br>";
                   outputPart = read.readLine();
               }

               // tmp: print results
               out.println("<!DOCTYPE html>");
               out.println("<html><head></head><body>");
               out.println("." + search_date_d + ".");
               out.println(finalOutput);
               out.println("</body></html>");   
            }
        }
    }
    
    boolean CheckDateValues(String d, String m, String y)
    {
        boolean ret = true;
        
        if (!(d.compareTo("1") == 0 || d.compareTo("2") == 0 || d.compareTo("3") == 0 || d.compareTo("4") == 0 || d.compareTo("5") == 0 || d.compareTo("6") == 0
                 || d.compareTo("7") == 0 || d.compareTo("8") == 0 || d.compareTo("9") == 0 || d.compareTo("10") == 0 || d.compareTo("11") == 0 || d.compareTo("12") == 0
                 || d.compareTo("13") == 0 || d.compareTo("14") == 0 || d.compareTo("15") == 0 || d.compareTo("16") == 0 || d.compareTo("17") == 0 || d.compareTo("18") == 0
                 || d.compareTo("19") == 0 || d.compareTo("20") == 0 || d.compareTo("21") == 0 || d.compareTo("22") == 0 || d.compareTo("23") == 0 || d.compareTo("24") == 0
                 || d.compareTo("25") == 0 || d.compareTo("26") == 0 || d.compareTo("27") == 0 || d.compareTo("28") == 0 || d.compareTo("29") == 0 || d.compareTo("30") == 0
                 || d.compareTo("31") == 0))
        {
            ret = false;
        }
        
        if (!(m.compareTo("1") == 0 || m.compareTo("2") == 0 || m.compareTo("3") == 0 || m.compareTo("4") == 0 || m.compareTo("5") == 0 || m.compareTo("6") == 0 || 
                m.compareTo("7") == 0 || m.compareTo("8") == 0 || m.compareTo("9") == 0 || m.compareTo("10") == 0 || m.compareTo("11") == 0 || m.compareTo("12") == 0))
        {
            ret = false;
        }
        
        try{
            Integer.parseInt(y);
        }catch(NumberFormatException e)
        {
            ret = false;
        }
        
        return ret;
    }
    
    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        response.setContentType("text/html");

        //RequestDispatcher reqDisp = request.getRequestDispatcher("busqueda.jsp");
        //request.setAttribute("FOUND_VIDEOS", GenerateTableOfVideos(request, response));
        //reqDisp.forward(request, response);
        }
    }
    
    String GenerateTableOfVideos(HttpServletRequest request, HttpServletResponse response)
    {
        String res = "";
        // Create list
        res += "<ul>";
        // Get number of elements
        int totalVids = 1;
        for (int i = 0; i < totalVids; i++)
        {
            res += GenerateElementVideo("Na", "aut", "des", 4, "link");
        }
        res += "</ul>";
        return res;
    }
    
    String GenerateElementVideo(String vidName, String vidAuthor, String vidDescription, int vidViews, String vidLink)
    {
        String res = "";
        res += "<li>";
        res += "<p>" + "Video Name: " + vidName + ", Video Author: " + vidAuthor + ", Video Description: " + vidDescription + ", Views: " + Integer.toString(vidViews);
        res += ", link: " + "<a href='" + vidLink + "/'>" + "Open" + "</a>";
        res += "</li>";
        return res;
    }
    
    // =======================================
    // ========= BASIC SERVLET CALLS =========
    // =======================================
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequestGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestPost(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Some info... ";
    }

}
