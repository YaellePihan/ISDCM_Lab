/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
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
        req.setAttribute("Table", CreateVideoTable());  // Create table
        reqDisp.forward(req, res);
    }
    
    String CreateVideoTable()
    {
        String ret = "<table>";
        try{
            ListVideos lv = new ListVideos();
            ArrayList<video> list_videos = lv.getList_videos();

            ret += "<tr> <th>ID</th> <th>Title</th> <th>Author</th> <th>Description</th> <th>Duration</th> <th>Upload date</th> <th>Number of reproductions</th> <th>Format</th> </tr>";    // PREGUNTA: CAL QUE CARREGUEM VIDEOS? O ELS DESCARREGUEM?
            for (int i = 0; i < list_videos.size(); i++) {
                video v = list_videos.get(i);
                ret += "<tr>" + "<td> " + v.getId() + "</td>";
                ret += "<td>" + v.getTitulo()+ "</td>";
                ret += "<td>" + v.getAutor() + "</td>";
                ret += "<td>" + v.getDescripcion()+ "</td>";            
                ret += "<td>" + v.getDuracion() + "</td>";
                ret += "<td>" + v.getFecha_creacion()+ "</td>";
                ret += "<td>" + v.getNum_reproduccion()+ "</td>";
                ret += "<td>" + v.getFormato()+ "</td>" + "</tr>";
            }
            ret += "</table>";
        }catch (NumberFormatException ex){}
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
    }        

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
