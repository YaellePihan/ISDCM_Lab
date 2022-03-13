package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import video.video;

import javax.servlet.RequestDispatcher;

@WebServlet(name = "servletRegistroVid", urlPatterns = {"/servletRegistroVid"})
public class servletRegistroVid extends HttpServlet {

    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletRegistroVid</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>GET CALLED! at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
        String title = request.getParameter("video_name");
        String description = request.getParameter("video_description");      

        video video = new video(title,"author","date","time",description,"format",1); 
        video.add_video_to_db();
        
        RequestDispatcher reqDisp = request.getRequestDispatcher("servletListadoVid");
        reqDisp.forward(request, response);
        }
    }
    
    // =======================================
    // ========= BASIC SERVLET CALLS =========
    // =======================================
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (req.getQueryString().compareTo("uploadvid") == 0)
        {
            processRequestPost(req, res);            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
