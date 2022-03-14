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

import usuario.usuario;

@WebServlet(name = "servletUsuarios", urlPatterns = {"/servletUsuarios"})
public class servletUsuarios extends HttpServlet {
     
    public void processPostRequestLogin(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        String user_name = req.getParameter("user_nick");
        String user_pass = req.getParameter("user_password");
        try{
            usuario user = new usuario();
            if (user.is_user_in_db(user_name, user_pass))
            {
                RequestDispatcher reqDisp = req.getRequestDispatcher("servletListadoVid");
                reqDisp.forward(req, res);
            }
            else
            {
                RequestDispatcher reqDisp = req.getRequestDispatcher("login.jsp");
                req.setAttribute("SYST_MESSAGE", "User or Password incorrect");
                reqDisp.forward(req, res);
            }
        }catch (NumberFormatException ex){}
    
        
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

        if (user_name.isEmpty() || user_surnames.isEmpty() || user_email.isEmpty() || user_nick.isEmpty() || user_pass1.isEmpty() || user_pass2.isEmpty())
        {
            RequestDispatcher reqDisp = req.getRequestDispatcher("registroUsu.jsp");
            req.setAttribute("SYST_MESSAGE", "System message: Any field with (*) can be empty!");
            reqDisp.forward(req, res);
        }
        else
        {
            if (user_pass1.compareTo(user_pass2) == 0 && !user_pass1.isEmpty())
            {
                if (!CheckIfEMailExist(user_email))
                {
                    usuario user = new usuario();
                    // Check if user is also created
                    if (!CheckIfUserExist(user, user_nick,user_pass1))
                    {
                        // Create user class
                        user.setNombre(user_name);
                        user.setApellidos(user_surnames);
                        user.setApodo(user_nick);
                        user.setContrasena(user_pass1);
                        user.setEmail(user_email);

                        // Add to the DataBase
                        String result = user.add_user_to_db();
                        // If user succesfully created:
                        RequestDispatcher reqDisp = req.getRequestDispatcher("login.jsp");
                        req.setAttribute("SYST_MESSAGE", "Created succesfully :), now can login!");
                        reqDisp.forward(req, res);
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
    }
    
    boolean CheckIfUserExist(usuario user, String user_nick, String user_pass1)
    {
        boolean result = user.is_user_in_db(user_nick, user_pass1);
        return result;
    }
    
    boolean CheckIfEMailExist(String userEMail)
    {
        boolean ret = false;
        // Search on the database
        return ret;
    }
    
    // =======================================
    // ========= BASIC SERVLET CALLS =========
    // =======================================
    
    
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
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
