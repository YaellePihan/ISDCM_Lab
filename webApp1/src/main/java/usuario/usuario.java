/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author alumne
 */
public class usuario {
    String nombre       = "-";  // "-" es no definit
    String apellidos    = "-";
    String apodo        = "-";
    String contrasena   = "-";
    String email        = "-";
    
    //Constructors
    public usuario(){};
    
    public usuario(String nom, String ape, String apo, String contr, String ema)
    {
        this.nombre = nom;
        this.apellidos = ape;
        this.apodo = apo;
        this.contrasena = contr;
        this.email = ema;
        // Estaria guay fer un print aquí per veure si es crea be
    }
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getApodo() {
        return apodo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEmail() {
        return email;
    }
    
    //Functions querying the database
    public String add_user_to_db(){
        String result = "Error when adding user to database";
        // define query
        String query = "insert into users values(?,?,?,?,?)";
        Connection c = null;
        try{
            // create a database connection
            result ="enter into try";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            result="before connection";            
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB;user=userDB;password=userDB");
            result ="connection:"+c;
            PreparedStatement statement;
            statement = c.prepareStatement(query);
            result ="statement:"+statement;
            statement.setString(1,this.getNombre());
            statement.setString(2,this.getApellidos());
            statement.setString(3,this.getEmail());
            statement.setString(4,this.getApodo());
            statement.setString(5,this.getContrasena());
            int i = statement.executeUpdate();
            result = "User successfully added to database";
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }finally {
            try {
                if (c != null) 
                    c.close();                
            } catch (SQLException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return result;
    }
    
    // function called by the servlet to know if a user is already stored in the database or not
    public Boolean is_user_in_db(String user, String passwd){
        //String result = "El usuario existe";
        Boolean result = true;
        String query = "select count(*) from users where username=? and password=?";
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB;user=userDB;password=userDB");
            PreparedStatement statement;
            statement = c.prepareStatement(query);
            statement.setString(1, user);
            statement.setString(2, passwd);   
            ResultSet r = statement.executeQuery();
        if (r.next())
            {
                if (r.getInt(1) == 0)
                    //result = "El usuario no existe";
                    result = false;
            }    
        }catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } finally {
            try {
                if (c != null) 
                    c.close();                
            } catch (SQLException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return result;
    }
}
