/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dkasamuebles;

import controlador.*;
import java.sql.Connection;

/**
 *
 * @author Astrid
 */
public class DKasaMuebles {
    
    public static ManejadorVentanas mv;
    public static String ClienteSelected; 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Connection con = new Conexion().getConexion();
        
        
        
        mv = new ManejadorVentanas();
        mv.loginfrm.setVisible(true);
        // TODO code application logic here
    }
    
}
