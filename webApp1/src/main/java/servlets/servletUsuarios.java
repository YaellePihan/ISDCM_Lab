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

/**
 *
 * @author alumne
 */
@WebServlet(name = "servletUsuarios", urlPatterns = {"/servletUsuarios"})
public class servletUsuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // Proves 1 - Isaac
    /*
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        String user = request.getParameter("user_name");
        String pass1 = request.getParameter("user_password");
        String pass2 = request.getParameter("user_password2");
        pw.println("login succed");
        if (pass1.equals(pass2))
        {
            pw.println("pass is the same");
        }
        else
        {
            pw.println("pass is NOT the same");
        }
    }
    */
    
    // Proves 2 - Isaac
    /*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    {
        String user     = req.getParameter("user_name");
        String pass1    = req.getParameter("user_password");
        String pass2    = req.getParameter("user_password2");
        
        System.out.println("Hola");
        
        req.getRequestDispatcher("/WEB-INF/registroUsu.jsp"); //.forward(req, res);
    }
    */
    
    // Proves 3 - Isaac
    public void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        res.setContentType("text/html");
        
        String user     = req.getParameter("user_name");
        String pass1    = req.getParameter("user_password");
        String pass2    = req.getParameter("user_password2");

        PrintWriter pwriter=res.getWriter();
        pwriter.print("<html>");
        pwriter.print("<body>");
        pwriter.print("<h2>Generic Servlet Example</h2>");
        pwriter.print(user);
        pwriter.print(pass1);
        pwriter.print(pass2);
        pwriter.print("Puta Espanya :)");
        pwriter.print("</body>");
        pwriter.print("</html>");
    }
    
    public void processPostRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        res.setContentType("text/html");
        
        String user_name        = req.getParameter("user_name");
        String user_surnames    = req.getParameter("user_surnames");
        String user_email       = req.getParameter("user_email");
        String user_nick        = req.getParameter("user_nick");
        String user_pass1       = req.getParameter("user_password");
        String user_pass2       = req.getParameter("user_password2");

        PrintWriter pwriter=res.getWriter();
        pwriter.print("<html>");
        pwriter.print("<body>");
        pwriter.print("<h2>Generic Servlet Example</h2>");
        pwriter.print(user_name + "<br>");
        pwriter.print(user_surnames + "<br>");
        pwriter.print(user_email + "<br>");
        pwriter.print(user_nick + "<br>");
        pwriter.print(user_pass1 + "<br>");
        pwriter.print(user_pass2 + "<br>");
        pwriter.print("</body>");
        pwriter.print("</html>");
    }

    
    // =================================
    // =========== DEFAULT =============
    // =================================

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
        processPostRequest(request, response);
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
