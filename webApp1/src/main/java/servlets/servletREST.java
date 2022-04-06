package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.servlet.RequestDispatcher;
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
            
            String urlToAsk = "http://localhost:8080/webApp2/resources/javaee8/searchVideo?";
            String requestParameters = "Title=" + "t" + "&Author" + "a" + "&Date" + "2020";
            urlToAsk += requestParameters;
            
            URL getVideoListURL = new URL(urlToAsk);
            HttpURLConnection http_connection = (HttpURLConnection)getVideoListURL.openConnection();
            http_connection.setRequestMethod("GET");
            http_connection.setRequestProperty("Accept", "text/plain");
            
            if(http_connection.getResponseCode() != 200)
            {
                // Add error message -- Isaac
            }
                        
            BufferedReader read = new BufferedReader(new InputStreamReader(http_connection.getInputStream(), "utf-8"));
            String outputPart = read.readLine();
            String finalOutput = null;
            while(outputPart != null)
            {
                finalOutput += outputPart;
                outputPart = read.readLine();
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html><head></head><body>");
            out.println(finalOutput);
            out.println("</body></html>");
            
            
        }
    }
    
    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        response.setContentType("text/html");

        //RequestDispatcher reqDisp = request.getRequestDispatcher("busqueda.jsp");
        //request.setAttribute("FOUND_VIDEOS", GenerateTableOfVideos(request, response));
        //reqDisp.forward(request, response);
        //RequestDispatcher reqDisp = request.getRequestDispatcher("http://localhost:8080/webApp2/resources/javaee8/getInfo");
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
