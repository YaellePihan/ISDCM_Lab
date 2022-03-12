/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

import usuario.usuario;

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
    
    public void processPostRequestLogin(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        String user_name        = req.getParameter("user_nick");
        String user_pass       = req.getParameter("user_password");
        
        PrintWriter pwriter = res.getWriter();

        pwriter.print(user_name);
        pwriter.print(user_pass);
        
        // TODO: Check login
        usuario user = new usuario();
        if (user.is_user_in_db(user_name, user_pass)){
            pwriter.print("user exist");
        }else{
            pwriter.print("user does not exist");
        }
        RequestDispatcher reqDisp = req.getRequestDispatcher("servletListadoVid");
        reqDisp.forward(req, res);
        
    }
    
    public void processPostRequestRegister(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        res.setContentType("text/html");
        
        String user_name        = req.getParameter("user_name");
        String user_surnames    = req.getParameter("user_surnames");
        String user_email       = req.getParameter("user_email");
        String user_nick        = req.getParameter("user_nick");
        String user_pass1       = req.getParameter("user_password");
        String user_pass2       = req.getParameter("user_password2");
        
        PrintWriter pwriter = res.getWriter();
        String syst_msg_toRegisterJSP = "";
        // Compare if the 2 passwords are the same or if is null
        if (user_pass1.compareTo(user_pass2) == 0 && !user_pass1.isEmpty())
        {
            usuario user = new usuario();
            if (!CheckIfEMailExist(user_email))
            {
                // Check if user is also created
                if (!CheckIfUserExist(user, user_nick,user_pass1))
                {
                    // Create user class
                    //usuario user = new usuario(user_name, user_surnames, user_nick, user_pass1, user_email);
                    user.setNombre(user_name);
                    user.setApellidos(user_surnames);
                    user.setApodo(user_nick);
                    user.setContrasena(user_pass1);
                    user.setEmail(user_email);
                    pwriter.print("<html>");
                    pwriter.print("<body>");
                    
                    /** to debug
                    pwriter.print(user_name+" "+user.getNombre()+"<br>");
                    pwriter.print(user_surnames+" "+user.getApellidos()+"<br>");
                    pwriter.print(user_nick+" "+user.getApodo()+"<br>");
                    pwriter.print(user_pass1+" "+user.getContrasena()+"<br>");
                    pwriter.print(user_email+" "+user.getEmail()+"<br>");
                    **/
                    // Add to the DataBase
                    String result = user.add_user_to_db();
                    // If user succesfully created:
                    
                    pwriter.print(result+"<br>");
                    pwriter.print("<a href='login.jsp'> Click to login </a>");
                    pwriter.print("</body>");
                    pwriter.print("</html>");
                    
                }
                else
                {
                syst_msg_toRegisterJSP = "System message: This user nickname already exsits !!!";
                }
            }
            else
            {
            syst_msg_toRegisterJSP = "System message: This user email already is used !!!";
            }
        }
        else
        {
        syst_msg_toRegisterJSP = "System message: Password1 != Password2 or Password = Null !!!";
        }
        
        if (!syst_msg_toRegisterJSP.isEmpty())
        {
            RequestDispatcher reqDisp = req.getRequestDispatcher("registroUsu.jsp");
            req.setAttribute("SYST_MESSAGE", syst_msg_toRegisterJSP);
            reqDisp.forward(req, res);
        }
    }
    
    boolean CheckIfUserExist(usuario user, String user_nick, String user_pass1)
    {
        //boolean result = false;
        // Search on the database
        boolean result = user.is_user_in_db(user_nick, user_pass1);

        return result;
    }
    
    boolean CheckIfEMailExist(String userEMail)
    {
        boolean ret = false;
        // Search on the database
        
        return ret;
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
        if (request.getQueryString().compareTo("login") == 0)
        {
            processPostRequestLogin(request, response);
        }
        else if (request.getQueryString().compareTo("register") == 0)
        {
            processPostRequestRegister(request, response);
        }
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
