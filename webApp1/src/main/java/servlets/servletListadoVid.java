/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

/**
 *
 * @author alumne
 */
@WebServlet(name = "servletListadoVid", urlPatterns = {"/servletListadoVid"})
public class servletListadoVid extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        res.setContentType("text/html");
        
        PrintWriter pwriter = res.getWriter();
                    
        RequestDispatcher reqDisp = req.getRequestDispatcher("listadoVid.jsp");
        
        // Create tables
        req.setAttribute("Table", CreateVideoTable());
        
        reqDisp.forward(req, res);
    }
    
    String CreateVideoTable()
    {
        String ret = "<table>";
        ret += "<tr> <th>Image</th> <th>Vid Name </th> <th>Description</th> </tr>";
        int numOfVid = 3;
        for (int i = 0; i < numOfVid; i++)
        {
            ret += "<tr> <td> " + i + "</td> <td> " + i + "</td> <td> " + i + "</td> </tr>";
        }
        ret += "</tr></table>";
        return ret;
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
