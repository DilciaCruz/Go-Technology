/**
 * Elaborado por Alexei Rodriguez y Franklin Villalta
 * Fecha 24/07/2017 12:09 pm
 * Versión 1.3
 */
package dkasamuebles;

import controlador.*;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;

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
    }
    
    //agregar ayuda para ser llamada en cualquier boton
    public static void ayuda(){
        Desktop archivo = Desktop.getDesktop();
        try {
            File ayuda = new File("src/ayuda.chm");
            archivo.open(ayuda);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
