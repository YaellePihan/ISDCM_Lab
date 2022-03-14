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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "servletRegistroVid", urlPatterns = {"/servletRegistroVid"})
public class servletRegistroVid extends HttpServlet {

    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher reqDisp = request.getRequestDispatcher("registroVid.jsp");
            reqDisp.forward(request, response);
        }
    }
    
    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
        // Ger variables through form
        String title            = request.getParameter("video_name");
        String description      = request.getParameter("video_description");
        String author           = request.getParameter("video_author");
        String duration         = request.getParameter("video_duration");
        
        if (title.isEmpty() || description.isEmpty() || author.isEmpty() || duration.isEmpty())
        {
            RequestDispatcher reqDisp = request.getRequestDispatcher("registroVid.jsp");
            request.setAttribute("SYST_MESSAGE", "System message: Any field with (*) can be empty!");
            reqDisp.forward(request, response);
        }
        else
        {
            // Get time
            DateTimeFormatter dft = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            // Get format
            

            try{
                video video = new video(title, author, dft.format(now), duration, description, "format",0);
                if(!video.is_video_in_db())
                {
                    video.add_video_to_db();
                    RequestDispatcher reqDisp = request.getRequestDispatcher("servletListadoVid");
                    request.setAttribute("SYST_MESSAGE", "System message: Video successfully added to database!");
                    reqDisp.forward(request, response);
                }
                else
                {
                    RequestDispatcher reqDisp = request.getRequestDispatcher("registroVid.jsp");
                    request.setAttribute("SYST_MESSAGE", "System message: Video Tittle already exists!");
                    reqDisp.forward(request, response);
                }
            }
            catch (NumberFormatException ex){
            }
        }
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
