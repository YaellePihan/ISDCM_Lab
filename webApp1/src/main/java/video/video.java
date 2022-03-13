/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author alumne
 */
public class video {
    String titulo;
    String autor;
    String fecha_creacion;
    String duracion;
    int num_reproduccion;
    String descripcion;
    String formato;

    //constructor 1 
    public video(){};
    
    //constructor 2
    public video(String title, String author, String date, String time, String description, String format, int nb){
        this.titulo = title;
        this.autor = author;
        this.fecha_creacion = date;
        this.duracion = time;
        this.descripcion = description;
        this.formato = format;
        this.num_reproduccion =nb;
    }

    //Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setNum_reproduccion(int num_reproduccion) {
        this.num_reproduccion = num_reproduccion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    //Getters

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getNum_reproduccion() {
        return num_reproduccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFormato() {
        return formato;
    }
    
    
    // to register a video in the database
    public String add_video_to_db(){
        String result = "Error when adding video to database";
        // define query
        String query = "insert into videos values(?,?,?,?,?,?,?)";
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
            statement.setString(1,this.getTitulo());
            statement.setString(2,this.getAutor());
            statement.setString(3,this.getFecha_creacion());
            statement.setString(4,this.getDuracion());
            statement.setInt(5,this.getNum_reproduccion());
            statement.setString(6,this.getDescripcion());
            statement.setString(7,this.getFormato());
            int i = statement.executeUpdate();
            result = "Video successfully added to database";
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
    
}