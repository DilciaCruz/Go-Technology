package dkasamuebles;

import controlador.*;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;

/**
 *
 * @author Villalta
 */
public class DKasaMuebles {
    
    public static ManejadorVentanas mv;
    public static String DatoSelected;
    public static int codigoBotonPresionado;

    public static void main(String[] args) {
        
        Connection con = new Conexion().getConexion();
        
        mv = new ManejadorVentanas();
        mv.loginfrm.setVisible(true);
    }
    
    //Función para poder llamar la ayuda 
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
