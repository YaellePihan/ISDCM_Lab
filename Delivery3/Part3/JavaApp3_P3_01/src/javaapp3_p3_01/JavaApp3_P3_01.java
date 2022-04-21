/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp3_p3_01;

/**
 *
 * @author alumne
 */
public class JavaApp3_P3_01 {

    public static String encryptXML(String filePath)
    {
        System.out.println(filePath);
        return filePath;
    }
    
    public static String decryptXML(String filePath)
    {
        System.out.println(filePath);
        return filePath;
    }
    
    public static void main(String[] args) {
        if (args[0].equals("EncryptXML"))
        {
            encryptXML(args[1]);
        }
        else if (args[0].equals("DecryptXML"))
        {
            decryptXML(args[1]);
        }
        
    }
}
