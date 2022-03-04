/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

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
    
    public usuario(String nom, String ape, String apo, String contr, String ema)
    {
        this.nombre = nom;
        this.apellidos = ape;
        this.apodo = apo;
        this.contrasena = contr;
        this.email = ema;
        // Estaria guay fer un print aquí per veure si es crea be
    }
    
}
