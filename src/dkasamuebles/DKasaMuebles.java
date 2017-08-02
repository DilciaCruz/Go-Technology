/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dkasamuebles;

import controlador.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Astrid
 */
public class DKasaMuebles {
    
    public static ManejadorVentanas mv;
    public static String DatoSelected;
    public static int codigoBotonPresionado;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Connection con = new Conexion().getConexion();
        
        mv = new ManejadorVentanas();
        mv.loginfrm.setVisible(true);
        // TODO code application logic here
    }
    
    public static void ayuda(){
        try {
            Desktop archivo = Desktop.getDesktop();
            File ayuda = new File ("src/ayuda.chm");
            archivo.open(ayuda);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
