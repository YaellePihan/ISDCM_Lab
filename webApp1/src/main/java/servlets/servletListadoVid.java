/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import video.ListVideos;
import video.video;

@WebServlet(name = "servletListadoVid", urlPatterns = {"/servletListadoVid"})
public class servletListadoVid extends HttpServlet {

    public void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        res.setContentType("text/html");
        
        RequestDispatcher reqDisp = req.getRequestDispatcher("listadoVid.jsp");
        req.setAttribute("Table", CreateVideoTable());  // Create tables
        reqDisp.forward(req, res);
    }
    
    String CreateVideoTable()
    {
        String ret = "<table>";
        
        ListVideos lv = new ListVideos();
        ArrayList<video> list_videos = lv.getList_videos();
        
        ret += "<tr> <th>Title </th> <th>Author </th></tr>";    // PREGUNTA: CAL QUE CARREGUEM VIDEOS? O ELS DESCARREGUEM?
        for (int i = 0; i < list_videos.size(); i++) {
            video v = list_videos.get(i);
            ret += "<tr> <td> " + v.getTitulo() + "</td> <td> " + v.getAutor() + "</td></tr>";	
        }
        ret += "</tr></table>";
        
        return ret;
    }
    
    // =======================================
    // ========= BASIC SERVLET CALLS =========
    // =======================================
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }        // Read and print in a table the list of videos


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
