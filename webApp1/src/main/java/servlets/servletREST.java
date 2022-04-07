package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

import java.util.ArrayList;
import java.util.Arrays;        // Potser es pot treure ?
import java.util.List;

import java.net.URL;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import video.video;

import video.ListVideos;


@WebServlet(name = "servletREST", urlPatterns = {"/servletREST"})
public class servletREST extends HttpServlet {
    
    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Get ValuesMalformedUrlException
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
                    System.out.println("Error on Response code!");
                }

                // Get Result
                BufferedReader read = new BufferedReader(new InputStreamReader(http_connection.getInputStream(), "utf-8"));
                String outputPart = read.readLine();
                String finalOutput = "";
                while(outputPart != null)
                {
                    finalOutput += outputPart;
                    outputPart = read.readLine();
                }
                
                List<video> videosFound = new ArrayList();
                Gson gson = new Gson();
                Type classOfT_VideoList = new TypeToken<List<video>>(){}.getType();
                videosFound = gson.fromJson(finalOutput, classOfT_VideoList);
               
                RequestDispatcher reqDisp = request.getRequestDispatcher("busqueda.jsp");
                request.setAttribute("FOUND_VIDEOS", GenerateTableOfVideos(videosFound));
                reqDisp.forward(request, response);
            }
        }
    }
    
    boolean CheckDateValues(String d, String m, String y)
    {
        boolean ret = true;
        // TODO: Check if its empty! IN PROGRESS
        if (!d.isEmpty())
        {
            if (!(d.compareTo("1") == 0 || d.compareTo("2") == 0 || d.compareTo("3") == 0 || d.compareTo("4") == 0 || d.compareTo("5") == 0 || d.compareTo("6") == 0
                     || d.compareTo("7") == 0 || d.compareTo("8") == 0 || d.compareTo("9") == 0 || d.compareTo("10") == 0 || d.compareTo("11") == 0 || d.compareTo("12") == 0
                     || d.compareTo("13") == 0 || d.compareTo("14") == 0 || d.compareTo("15") == 0 || d.compareTo("16") == 0 || d.compareTo("17") == 0 || d.compareTo("18") == 0
                     || d.compareTo("19") == 0 || d.compareTo("20") == 0 || d.compareTo("21") == 0 || d.compareTo("22") == 0 || d.compareTo("23") == 0 || d.compareTo("24") == 0
                     || d.compareTo("25") == 0 || d.compareTo("26") == 0 || d.compareTo("27") == 0 || d.compareTo("28") == 0 || d.compareTo("29") == 0 || d.compareTo("30") == 0
                     || d.compareTo("31") == 0))
            {
                ret = false;
            }
        }
        
        if (!m.isEmpty())
        {
            if (!(m.compareTo("1") == 0 || m.compareTo("2") == 0 || m.compareTo("3") == 0 || m.compareTo("4") == 0 || m.compareTo("5") == 0 || m.compareTo("6") == 0 || 
                    m.compareTo("7") == 0 || m.compareTo("8") == 0 || m.compareTo("9") == 0 || m.compareTo("10") == 0 || m.compareTo("11") == 0 || m.compareTo("12") == 0))
            {
                ret = false;
            }
        }
        
        if (!y.isEmpty())
        {
            try{
                Integer.parseInt(y);
            }catch(NumberFormatException e)
            {
                ret = false;
            }
        }
        
        return ret;
    }
    
    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        response.setContentType("text/html");
        }
    }
    
    String GenerateTableOfVideos(List<video> videos)
    {
        String res = "";
        // Create list
        res += "<ul>";
        for (int i = 0; i < videos.size(); i++)
        {
            res += GenerateElementVideo(videos.get(i).getTitulo(), videos.get(i).getAutor(), videos.get(i).getDescripcion(),
                    videos.get(i).getNum_reproduccion(), videos.get(i).getFecha_creacion(), videos.get(i).getId());
        }
        res += "</ul>";
        return res;
    }
    
    String GenerateElementVideo(String vidName, String vidAuthor, String vidDescription, int vidViews, String creationDate, int id)
    {
        String res = "";
        res += "<li>";
        res += "<form action='servletREST?VidID=" + id +  "' method='POST'>";
        res += "<p>" + "Video Name: " + vidName + ", Video Author: " + vidAuthor + ", Video Description: " + vidDescription + ", Views: " + Integer.toString(vidViews);
        res += "<input type='submit' value='Abrir'>";
        res += "</form>";
        res += "</li>";
        return res;
    }
    
    protected void processRequestPostGoVideo(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Get video via ID
            int index = Integer.valueOf(request.getQueryString().substring(6));
            
            // Get video values
            ListVideos listVideos = new ListVideos();
            video videoToShow = listVideos.GetVideoFromID(index);
            
            // Sum 1 view via REST
            String viewsUpdated = SumOneView(index);
            
            // Load Video page
            RequestDispatcher reqDisp = request.getRequestDispatcher("reproduccion.jsp");
            request.setAttribute("VID_TITLE", videoToShow.getTitulo());
            request.setAttribute("VID_VIEWS", viewsUpdated);
            request.setAttribute("VID_CREATION_DATE", videoToShow.getFecha_creacion());
            request.setAttribute("VID_AUTHOR", videoToShow.getAutor());
            reqDisp.forward(request, response);
        }
    }
    
    String SumOneView(int videoID)
    {
        String ret = "";
        try
        {
            URL urlIncreaseViewREST = new URL("http://localhost:8080/webApp2/resources/javaee8/increaseViews");
            HttpURLConnection http_connection = (HttpURLConnection)urlIncreaseViewREST.openConnection();
            http_connection.setRequestMethod("POST");
            http_connection.setRequestProperty("Accept", "text/plain");
            http_connection.setDoOutput(true);
            String param1 = "VideoID=" + videoID;
            
            OutputStream output = http_connection.getOutputStream();
            output.write(param1.getBytes());
            output.flush();
            output.close();
            
            if (http_connection.getResponseCode() != 200)
            {
                System.out.println("Error on Response code!");
            }
            BufferedReader read = new BufferedReader(new InputStreamReader(http_connection.getInputStream(), "utf-8"));
            
            String outputPart = read.readLine();
            String finalOutput = "";
            while(outputPart != null)
            {
                finalOutput += outputPart;
                outputPart = read.readLine();
            }
            ret = finalOutput;
        } catch(MalformedURLException e)
        {
            System.out.println(e.toString());
        } catch(RuntimeException e)
        {
            System.out.println(e.toString());
        } catch(IOException e)
        {
            System.out.println(e.toString());
        }
        
        return ret;
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
        String queryName = request.getQueryString().substring(0, 5);
        if(queryName.compareTo("VidID") == 0)
        {
            processRequestPostGoVideo(request, response);
        }
        else
        {
            processRequestPost(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Some info... ";
    }

}
