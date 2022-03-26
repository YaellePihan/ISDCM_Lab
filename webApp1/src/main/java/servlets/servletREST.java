package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

@WebServlet(name = "servletREST", urlPatterns = {"/servletREST"})
public class servletREST extends HttpServlet {
    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }
    
    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Generate video list (with search parameters)
        response.setContentType("text/html");

        RequestDispatcher reqDisp = request.getRequestDispatcher("busqueda.jsp");
        
        // request.setAttribute("FOUND_VIDEOS", GenerateTableOfVideos(request, response));        
        
        reqDisp.forward(request, response);
            
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
